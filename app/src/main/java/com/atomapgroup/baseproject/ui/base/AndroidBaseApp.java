package com.atomapgroup.baseproject.ui.base;

import android.app.Application;
import android.content.Context;


public class AndroidBaseApp extends Application {

    private static AndroidBaseApp mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


    }

    public static AndroidBaseApp getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

}