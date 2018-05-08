package com.atomapgroup.halalfood.data.network.retrofit;

import com.atomapgroup.halalfood.data.network.Endpoints;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobarak on 26-Feb-18.
 */

public class ApiError {

    @SerializedName(Endpoints.STATUS)
    private int statusCode;
    @SerializedName(Endpoints.CODE)
    private int errorCode;
    @SerializedName(Endpoints.MESSAGE)
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
