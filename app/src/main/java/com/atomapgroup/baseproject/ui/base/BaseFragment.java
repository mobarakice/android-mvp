package com.atomapgroup.baseproject.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.atomapgroup.baseproject.utils.UtilityFunctions;


/**
 * Created by Mobarak on 22-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public class BaseFragment extends Fragment {

    public BaseFragment() {

    }


    /**
     * Invoke to back in previous fragment
     *
     * @return true|false
     */
    public boolean popFragment() {
        boolean isPop = false;
        if (getActivity() != null) {
            UtilityFunctions.hideVirtualKeyboard(getActivity());
            Log.e("getBackStackEntryCount ", "getBackStackEntryCount: "
                    + getActivity().getSupportFragmentManager().getBackStackEntryCount());
            if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                isPop = true;
                getActivity().getSupportFragmentManager().popBackStack();
            }
        }
        return isPop;
    }


    /**
     * Invoke to back parent fragment
     */
    public void popBackToFragment() {
        if (getActivity() != null) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            int count = fm.getBackStackEntryCount();
            Log.e("getBackStackEntryCount ", "getBackStackEntryCount: " + count);
            for (int i = 0; i < count; ++i) {
                fm.popBackStack();
            }
        }
    }


    /**
     * @param view
     * @param activity
     */
    protected void hideSoftKeyboardByTouchingOutSideEditField(View view, final FragmentActivity activity) {

        if (view == null || activity == null) {
            return;
        }
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    UtilityFunctions.hideVirtualKeyboard(activity);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                hideSoftKeyboardByTouchingOutSideEditField(innerView, activity);
            }
        }
    }

    /**
     * Invoke to controlling visibility of BottomNavigationBar
     * If @isShow is true BottomNavBar is visible
     * Else BottomNavBar is Gone
     *
     * @param isShow true| false
     */
    protected void controlledBottomBar(boolean isShow) {
        if (getActivity() == null) {
            return;
        }

        if (isShow) {
            ((IWindowBarController) getActivity()).showBottomBar();
        } else {
            ((IWindowBarController) getActivity()).hideBottomBar();
        }
    }

    /**
     * Invoke to controlling visibility of ActionBar (Toolbar)
     * If @isShow is true ActionBar is visible
     * Else ActionBar is Gone
     *
     * @param isShow true| false
     */
    protected void controlledToolbar(boolean isShow) {
        if (getActivity() == null) {
            return;
        }

        if (isShow) {
            ((IWindowBarController) getActivity()).showToolbar();
        } else {
            ((IWindowBarController) getActivity()).hideToolbar();
        }
    }

    /**
     * Invoke to controlling visibility of BackArrow (Toolbar)
     * If @isShow is true BackArrow is visible
     * Else BackArrow is Gone
     *
     * @param isShow true| false
     */
    protected void controlledBackArrow(boolean isShow) {
        if (getActivity() == null) {
            return;
        }

        if (isShow) {
            ((IWindowBarController) getActivity()).showBackArrow();
        } else {
            ((IWindowBarController) getActivity()).hideBackArrow();
        }
    }

    /**
     * Invoke to controlling visibility of BackArrow (Toolbar)
     * If @isShow is true BackArrow is visible
     * Else BackArrow is Gone
     *
     * @param title String
     */
    protected void setTitleText(String title) {
        if (getActivity() == null || title == null) {
            return;
        }
        ((IWindowBarController) getActivity()).setTitleText(title);
    }




}
