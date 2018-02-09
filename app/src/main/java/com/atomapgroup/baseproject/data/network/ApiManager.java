package com.atomapgroup.baseproject.data.network;

import android.support.annotation.NonNull;

import com.atomapgroup.baseproject.data.model.User;

import org.json.JSONObject;

/**
 * This is singleton ApiManager class and used to manage all API calling
 * Created by Mobarak on 26-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public class ApiManager implements IApiHelper {

    /**
     * Global instance of ApiManager
     */
    private static ApiManager mInstance;

    /**
     * Default private constructor
     */
    private ApiManager() {

    }

    /**
     * Invoke to get ApiManager instance. If instance is null,
     * then create new object otherwise return previous one
     *
     * @return mInstance
     */
    public static synchronized ApiManager getInstance() {
        if (mInstance == null) {
            mInstance = new ApiManager();
        }
        return mInstance;
    }

    /**
     * Invok to call vendor login API
     *
     * @param callback IResponseCallback
     * @param user
     */
    @Override
    public void invokeLoginAPI(@NonNull IResponseCallback callback, @NonNull User user) {
        JSONObject object = JsonUtil.getLoginJsonObject(user);
        new JsonParser(callback).postMethod(ApiUrls.LOGIN_API_URL, object);

    }

    /**
     * Invok to call vendor logout API
     *
     * @param callback IResponseCallback
     * @param userId String
     */
    @Override
    public void invokeLogoutAPI(IResponseCallback callback, @NonNull String userId) {
        JSONObject object = JsonUtil.getVendorCommonJsonObject(userId);
        new JsonParser(callback).postMethod(ApiUrls.LOGOUT_API_URL, object);
    }


}
