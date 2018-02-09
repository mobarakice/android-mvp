package com.atomapgroup.baseproject.ui.splash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atomapgroup.baseproject.R;
import com.atomapgroup.baseproject.ui.base.BaseFragment;
import com.atomapgroup.baseproject.utils.UtilityFunctions;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends BaseFragment implements ISplashContract.IView {

    private ISplashContract.IPresenter mPresenter;

    /**
     * Splash screen time
     */
    private static final int SPLASH_TIME = 3000;


    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilityFunctions.setStatusBarTransparent(getActivity(), true);
        mPresenter = new SplashPresenter(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        controlledToolbar(false);
        controlledBottomBar(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.waitSplshScreen(SPLASH_TIME);
    }

    /**
     * Invoke to goto login screen
     */
    @Override
    public void gotoLogin() {

    }

    @Override
    public void gotoHome() {


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
