package com.atomapgroup.baseproject.ui.user;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;

import com.atomapgroup.baseproject.data.DataManager;
import com.atomapgroup.baseproject.data.model.User;

import java.util.List;
import java.util.logging.Handler;


/**
 * This is presenter class and all business logic implemented in it.
 * Created by Mobarak on 22-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public class UserPresenter implements IUserContract.IPresenter {


    private FragmentActivity context;
    private IUserContract.IView userView;

    private static final String TAG = UserPresenter.class.getSimpleName();

    /**
     * Constructor of user presenter
     *
     * @param context
     * @param userView
     */
    public UserPresenter(FragmentActivity context, IUserContract.IView userView) {
        this.context = context;
        this.userView = userView;
    }

    @Override
    public void validateInput(String name, String email, String mobile) {
        if (name == null || TextUtils.isEmpty(name)) {
            userView.setNameError("Name required");
            return;
        }
        if (email == null || TextUtils.isEmpty(email)) {
            userView.setEmailError("Email required");
            return;
        }
        if (mobile == null || TextUtils.isEmpty(mobile)) {
            userView.setMobileError("Name required");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);

        insertUser(user);
    }

    @Override
    public void insertUser(User user) {
        Log.i(TAG, "insertUser called");
        if (user == null) return;
        new Thread(() -> {
            DataManager.getInstance().insert(user);
        }).start();
    }

    @Override
    public void updateUser(User user) {
        Log.i(TAG, "updateUser called");
    }

    @Override
    public void deleteUser(User user) {
        Log.i(TAG, "deleteUser called");
    }

    @Override
    public void findUser(User user) {
        Log.i(TAG, "findUser called");
    }

    @Override
    public void getAllUser() {
        Log.i(TAG, "getAllUser called");
        new Thread(() -> {
            List<User> users = DataManager.getInstance().getAll();
            userView.load(users);
        }).start();
    }
}
