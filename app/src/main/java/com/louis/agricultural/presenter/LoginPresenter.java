package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.mode.LoginActivityMode;
import com.louis.agricultural.model.mode.impl.LoginActivityModeImpl;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.ui.view.ILoginView;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/1/23 13:41
 * @des
 */
public class LoginPresenter extends UserLosePresenter<ILoginView> implements UserLoseMultiLoadedListener<BaseEntity>{

    private ILoginView mILoginView;
    private LoginActivityMode mLoginActivityMode;

    public LoginPresenter(ILoginView view) {
        mILoginView = view;
        mLoginActivityMode = new LoginActivityModeImpl((Activity)view);
    }

    /**
     * 登陆
     * @param user_name
     * @param user_pass
     */
    public void login(String user_name, String user_pass) {
        mLoginActivityMode.login(user_name, user_pass, this);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.USER_LOGIN_LISTENER:
                mILoginView.loginSuccess((UserEntity)data);
                break;
        }
    }
}
