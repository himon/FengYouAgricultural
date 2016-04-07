package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.UserInfoActivityMode;

/**
 * Created by lc on 16/3/2.
 */
public class UserInfoactivityModeImpl extends BaseMode implements UserInfoActivityMode {

    private Activity mActivity;

    public UserInfoactivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void getUserInfomation(String id, UserLoseMultiLoadedListener listener) {
        mManager.getUserInfomation(id, listener, mActivity);
    }

    @Override
    public void getUserImg(String user_id, UserLoseMultiLoadedListener listener) {
        mManager.getUserImg(user_id, listener, mActivity);
    }

    @Override
    public void uploadImg(String user_id, String images, UserLoseMultiLoadedListener listener) {
        mManager.uploadImg(user_id, images, listener, mActivity);
    }

    @Override
    public void userUpuserinformation(String user_id, String strxgname, String nick_name, UserLoseMultiLoadedListener listener) {
        mManager.userUpuserinformation(user_id, strxgname, nick_name, listener, mActivity);
    }
}
