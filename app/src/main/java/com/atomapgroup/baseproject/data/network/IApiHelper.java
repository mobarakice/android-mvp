package com.atomapgroup.baseproject.data.network;

import android.support.annotation.NonNull;

import com.atomapgroup.baseproject.data.model.User;

/**
 * This is a API helper interface
 * Created by Mobarak on 26-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public interface IApiHelper {

    void invokeLoginAPI(@NonNull IResponseCallback callback, @NonNull User user);

    void invokeLogoutAPI(@NonNull IResponseCallback callback, @NonNull String userId);

}
