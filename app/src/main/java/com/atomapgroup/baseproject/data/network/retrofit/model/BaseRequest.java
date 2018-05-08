package com.atomapgroup.halalfood.data.network.retrofit.model;

import com.atomapgroup.halalfood.data.network.Endpoints;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mobarak on 23-Feb-18.
 */

public class BaseRequest {

    @SerializedName(Endpoints.TERMINAL_ID)
    private String terminalId;
    @SerializedName(Endpoints.LANGUAGE)
    private String language;
    @SerializedName(Endpoints.FCM_TOKEN)
    private String fcmToken;
    @SerializedName(Endpoints.TOKEN)
    private String token;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
