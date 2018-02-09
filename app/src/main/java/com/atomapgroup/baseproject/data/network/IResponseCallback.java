package com.atomapgroup.baseproject.data.network;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Mobarak on 09/02/2018.
 */

public interface IResponseCallback {

    void onResponse(JSONObject response);

    void onErrorResponse(VolleyError error);


}
