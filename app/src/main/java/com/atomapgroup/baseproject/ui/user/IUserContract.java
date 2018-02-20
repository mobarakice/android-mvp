package com.atomapgroup.baseproject.ui.user;


import com.atomapgroup.baseproject.data.model.User;
import com.atomapgroup.baseproject.ui.base.IBasePresenter;
import com.atomapgroup.baseproject.ui.base.IBaseView;

import java.util.List;

/**
 * This interface is used to communicates between view and presenter
 * Created by Mobarak on 22-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public interface IUserContract {

    interface IView extends IBaseView<IPresenter> {
        void attemptToInsert();

        void load(List<User> users);

        void setNameError(String error);

        void setEmailError(String error);

        void setMobileError(String error);
    }

    interface IPresenter extends IBasePresenter {

        void validateInput(String name, String email, String mobile);

        void insertUser(User user);

        void updateUser(User user);

        void deleteUser(User user);

        void findUser(User user);

        void getAllUser();

    }
}
