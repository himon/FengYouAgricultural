package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.LoginActivityMode;

/**
 * Created by lc on 16/3/1.
 */
public class LoginActivityModeImpl extends BaseMode implements LoginActivityMode{

    private Activity mActivity;

    public LoginActivityModeImpl(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void login(String user_name, String user_pass, UserLoseMultiLoadedListener listener) {
        mManager.login(user_name, user_pass, listener, mActivity);
    }
}
