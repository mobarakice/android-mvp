package com.atomapgroup.halalfood.data.network.retrofit.model;

import com.atomapgroup.halalfood.data.network.Endpoints;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mobarak on 26-Feb-18.
 */

public class BaseResponse {

    @SerializedName(Endpoints.STATUS)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
