package com.atomapgroup.baseproject.ui.splash;

import android.os.Handler;


/**
 * This is presenter class and all business logic implemented in it.
 * Created by Mobarak on 22-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public class SplashPresenter implements ISplashContract.IPresenter {


    private ISplashContract.IView mSplashView;

    /**
     * Constructor of splash presenter
     *
     * @param splashView
     */
    public SplashPresenter(ISplashContract.IView splashView) {
        mSplashView = splashView;

    }

    /**
     * Invoke for trasfer splash screen to login screen after given time
     *
     * @param millisecond waiting time that this screen is visible by user
     */
    @Override
    public void waitSplshScreen(int millisecond) {
        new Handler().postDelayed(() -> {
            if (mSplashView != null) {
            }
        }, millisecond);
    }
}
