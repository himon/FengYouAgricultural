package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.UpdateUserInfoActivityMode;

/**
 * Created by lc on 16/4/6.
 */
public class UpdateUserInfoActivityModeImpl extends BaseMode implements UpdateUserInfoActivityMode{

    private Activity mActivity;

    public UpdateUserInfoActivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void userUpuserinformation(String nick_name, UserLoseMultiLoadedListener listener) {
        mManager.userUpuserinformation(nick_name, listener, mActivity);
    }
}
