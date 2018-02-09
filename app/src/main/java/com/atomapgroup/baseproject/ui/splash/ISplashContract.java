package com.atomapgroup.baseproject.ui.splash;


import com.atomapgroup.baseproject.ui.base.IBasePresenter;
import com.atomapgroup.baseproject.ui.base.IBaseView;

/**
 * This interface is used to communicates between view and presenter
 * Created by Mobarak on 22-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public interface ISplashContract {

    interface IView extends IBaseView<IPresenter> {
        void gotoLogin();

        void gotoHome();

    }

    interface IPresenter extends IBasePresenter {
        void waitSplshScreen(int millisecond);

    }
}
