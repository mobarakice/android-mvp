package com.atomapgroup.baseproject.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.atomapgroup.baseproject.ui.base.AndroidBaseApp;
import com.atomapgroup.baseproject.utils.Constants;


/**
 * This is a sharedpreference singleton class and used for save,
 * retrive and removing small amount of data locally
 * Created by Mobarak on 26-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public class PreferenceManager implements IPreferenceHelper {


    /**
     * Global instance of PreferenceManager
     */
    private static PreferenceManager mInstance;

    // SharedPreference name key
    private final String PREFERENCE_NAME = "android_bas_preference";


    // Authentication token key
    private final String FOODLLEE_TOKEN = "android_bas_auth_token";

    // FCM token key
    private final String FCM_TOKEN = "fcm_token";

    private static final String SELECTED_LANGUAGE = "Locale_Helper_Selected_Language";


    // SharedPreference and Editor instance
    private SharedPreferences sharedPreferences;

    /**
     * Default constactor
     */
    private PreferenceManager() {
        sharedPreferences = AndroidBaseApp.getAppContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Invoke to get/retrieve PreferenceManager instance. If instance is null
     * then create new instance otherwise return previous one
     *
     * @return mInstance
     */
    public static synchronized PreferenceManager getInstance() {
        if (mInstance == null) {
            mInstance = new PreferenceManager();
        }
        return mInstance;
    }


    /**
     * Invoke to set/save authentication token after login
     *
     * @param token String
     */
    @Override
    public void setAuthToken(String token) {
        sharedPreferences.edit().putString(FOODLLEE_TOKEN, token).commit();
    }


    /**
     * Invoke to get authentication token
     *
     * @return string
     */
    @Override
    public String getAuthToken() {
        return sharedPreferences.getString(FOODLLEE_TOKEN, null);
    }

    /**
     * Invoke to save deviceId/terminalId/MacAddress
     *
     * @param terminalId String
     */
    @Override
    public void setTerminalId(String terminalId) {
        sharedPreferences.edit().putString(Constants.TERMINAL_ID, terminalId).commit();
    }

    /**
     * Invoke to retrieve deviceId/terminalId/MacAddress
     *
     * @return string
     */
    @Override
    public String getTerminalId() {
        return sharedPreferences.getString(Constants.TERMINAL_ID, null);
    }

    /**
     * Invoke to save FirebaseToken
     *
     * @param token string
     */
    @Override
    public void setFcmToken(@NonNull String token) {
        sharedPreferences.edit().putString(FCM_TOKEN, token).commit();
    }

    /**
     * Invoke to retrieve FCM Token
     *
     * @return string
     */
    @Override
    public String getFcmToken() {
        return sharedPreferences.getString(FCM_TOKEN, null);
    }


    /**
     * invoke locale data
     *
     * @param context
     * @param language
     */
    @Override
    public void setLocaleParsistData(@NonNull Context context, String language) {
        sharedPreferences.edit().putString(SELECTED_LANGUAGE, language).commit();
    }

    /**
     * To retrieve locale data
     *
     * @param context
     * @param defaultLanguage
     * @return
     */
    @Override
    public String getLocalePersistedData(Context context, String defaultLanguage) {
        return sharedPreferences.getString(SELECTED_LANGUAGE, defaultLanguage);
    }
}
