package com.atomapgroup.baseproject.ui.base;

import android.support.annotation.NonNull;

/**
 * Created by Mobarak on 13-Oct-17.
 *
 * @author Atom AP Ltd.
 */

public interface IWindowBarController {

    void showToolbar();

    void hideToolbar();

    void initializedToolbar();

    void showBottomBar();

    void hideBottomBar();

    void showBackArrow();

    void hideBackArrow();

    void setTitleText(@NonNull String title);
}
