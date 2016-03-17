package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.UpdatePasswordActivityMode;

/**
 * Created by lc on 16/3/16.
 */
public class UpdatePasswordActivityModeImpl extends BaseMode implements UpdatePasswordActivityMode {

    private Activity mActivity;

    public UpdatePasswordActivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void userUpdatePass(String user_id, String user_pass, String new_pass, UserLoseMultiLoadedListener listener) {
        mManager.userUpdatePass(user_id, user_pass, new_pass, listener, mActivity);
    }
}
