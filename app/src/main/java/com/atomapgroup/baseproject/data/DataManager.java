package com.atomapgroup.baseproject.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.atomapgroup.baseproject.data.db.DbManager;
import com.atomapgroup.baseproject.data.db.IDbHelper;
import com.atomapgroup.baseproject.data.model.User;
import com.atomapgroup.baseproject.data.network.ApiManager;
import com.atomapgroup.baseproject.data.network.IApiHelper;
import com.atomapgroup.baseproject.data.network.IResponseCallback;
import com.atomapgroup.baseproject.data.prefs.IPreferenceHelper;
import com.atomapgroup.baseproject.data.prefs.PreferenceManager;

/**
 * This is singleton DataManager class and used to manipulate all kinds of data
 * Created by Mobarak on 09-Feb-18.
 *
 * @author Atom AP Ltd.
 */

public class DataManager implements IPreferenceHelper, IApiHelper, IDbHelper {

    /**
     * IPreferenceHelper instance;
     */
    private IPreferenceHelper mPreferenceHelper;
    /**
     * IApiHelper instance;
     */
    private IApiHelper mApiHelper;
    /**
     * IDbHelper instance;
     */
    private IDbHelper mDbHelper;
    /**
     * DataManager instance;
     */
    private static DataManager instance;

    /**
     * Default contsructor
     */
    private DataManager() {
        mPreferenceHelper = PreferenceManager.getInstance();
        mApiHelper = ApiManager.getInstance();
        mDbHelper = DbManager.getInstance();
    }

    /**
     * Invoke to get DataManager instance. If instance is null,
     * then create new object otherwise return previous one
     *
     * @return mInstance
     */
    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null)
                    instance = new DataManager();
            }
        }
        return instance;
    }


    @Override
    public void setAuthToken(@NonNull String token) {
        mPreferenceHelper.setAuthToken(token);
    }

    @Override
    public String getAuthToken() {
        return mPreferenceHelper.getAuthToken();
    }

    @Override
    public void setTerminalId(@NonNull String terminalId) {
        mPreferenceHelper.setTerminalId(terminalId);
    }

    @Override
    public String getTerminalId() {
        return mPreferenceHelper.getTerminalId();
    }

    @Override
    public void setFcmToken(@NonNull String token) {
        mPreferenceHelper.setFcmToken(token);
    }

    @Override
    public String getFcmToken() {
        return mPreferenceHelper.getFcmToken();
    }

    @Override
    public void setLocaleParsistData(@NonNull Context context, String language) {
        mPreferenceHelper.setLocaleParsistData(context, language);
    }

    @Override
    public String getLocalePersistedData(Context context, String defaultLanguage) {
        return mPreferenceHelper.getLocalePersistedData(context, defaultLanguage);
    }

    @Override
    public void invokeLoginAPI(@NonNull IResponseCallback callback, @NonNull User user) {
        mApiHelper.invokeLoginAPI(callback, user);
    }

    @Override
    public void invokeLogoutAPI(@NonNull IResponseCallback callback, @NonNull String userId) {
        mApiHelper.invokeLogoutAPI(callback, userId);
    }
}
