package com.louis.agricultural.model.mode.impl;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.RegisterActivityMode;
import com.louis.agricultural.presenter.RegisterPresenter;
import com.louis.agricultural.ui.view.IRegisterView;

/**
 * Created by lc on 16/3/1.
 */
public class RegisterActivityModeImpl extends BaseMode implements RegisterActivityMode {

    private Activity mActivity;

    public RegisterActivityModeImpl(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * 验证账号是否注册
     *
     * @param username
     * @param listener
     */
    @Override
    public void existsMobile(String username, UserLoseMultiLoadedListener listener) {
        mManager.existsMobile(username, listener, mActivity);
    }

    @Override
    public void register(String name, String mobile, String code, String pwd, UserLoseMultiLoadedListener listener) {
        mManager.register(name, mobile, code, pwd, listener, mActivity);
    }
}
