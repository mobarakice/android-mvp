package com.atomapgroup.baseproject.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;

import com.atomapgroup.baseproject.data.DataManager;

import java.util.Locale;

/**
 * This class is used to change application locale and persist this change for the next time
 * that the app is going to be used.
 * <p>
 * Also change the locale of application on the fly by using the setLocale method.
 * <p>
 * Created by moontasirul on 1/4/2018.
 * Updated by mobarak on 09/02/2018
 *
 * @author Atom AP Ltd.
 */

public class LocaleUtil {

    /*
    onAttach(Context context) constructor it will just set default
    locale of device as the default locale of your application.
     */

    public static Context onAttach(Context context) {
        String lang = DataManager.getInstance().getLocalePersistedData(context, Locale.getDefault().getLanguage());
        return setLocale(context, lang);
    }


    public static String getLanguage(Context context) {
        String lang = "";
        if (context != null) {
            lang = DataManager.getInstance().getLocalePersistedData(context, Locale.getDefault().getLanguage());
        }
        return lang;
    }

    public static Context setLocale(Context context, String language) {
        DataManager.getInstance().setLocaleParsistData(context, language);
        return updateResources(context, language);
    }

    /**
     * Invoke to update resource after changed language
     *
     * @param context  activity instance
     * @param language short code of a language
     * @return
     */
    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        return context;
    }

    /**
     * Invoke to change language
     *
     * @param activity activity instance
     * @param language short code of a language
     */
    public static void ChangeLanguage(FragmentActivity activity, final String language) {
        if (activity == null || language == null) return;
        setLocale(activity, language);
        activity.recreate();
    }

}
