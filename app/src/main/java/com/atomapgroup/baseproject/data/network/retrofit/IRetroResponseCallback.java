package com.atomapgroup.halalfood.data.network.retrofit;

/**
 * Created by Mobarak on 26-Feb-18.
 */

public interface IRetroResponseCallback {

    <T> void onSuccessResponse(T response);

    void onErrorResponse(ApiError error);

    void onFailedResponse(Throwable t);
}
