package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.ForgetPasswordActivityMode;
import com.louis.agricultural.presenter.ForgetPasswordNextPresenter;

/**
 * Created by lc on 16/3/2.
 */
public class ForgetPasswordActivityModeImpl extends BaseMode implements ForgetPasswordActivityMode {

    private Activity mActivity;

    public ForgetPasswordActivityModeImpl(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void userUpdatePass(String user_id, String user_pass, String new_pass, UserLoseMultiLoadedListener listener) {
        mManager.userUpdatePass(user_id, user_pass, new_pass, listener, mActivity);
    }
}
