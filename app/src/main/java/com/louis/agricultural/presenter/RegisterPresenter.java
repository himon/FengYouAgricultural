package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.mode.RegisterActivityMode;
import com.louis.agricultural.model.mode.impl.RegisterActivityModeImpl;
import com.louis.agricultural.ui.view.IRegisterView;
import com.louis.agricultural.utils.StringUtil;

/**
 * Created by lc on 16/3/1.
 */
public class RegisterPresenter extends UserLosePresenter<IRegisterView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IRegisterView mIRegisterView;
    private RegisterActivityMode mRegisterActivityMode;

    public RegisterPresenter(IRegisterView view) {
        mIRegisterView = view;
        mRegisterActivityMode = new RegisterActivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag) {
            case Constants.EXISTS_MOBILE_LISTENER:
                mIRegisterView.setExistsMobileResult(data);
                break;
            case Constants.USER_REGISTER_LISTENER:
                mIRegisterView.registerSuccess((UserEntity)data);
                break;
        }
    }

    /**
     * 验证账号是否注册
     *
     * @param username
     */
    public void existsMobile(String username) {
        mRegisterActivityMode.existsMobile(username, this);
    }

    /**
     * 验证手机号码
     *
     * @param mobile
     */
    public void validateMobile(String mobile) {
        if (StringUtil.isPhoneNum(mobile)) {
            mIRegisterView.setValidateResult(true);
        } else {
            mIRegisterView.setValidateResult(false);
        }
    }

    /**
     * 验证密码
     *
     * @param pwd
     */
    public void validatePwd(String pwd) {

        int len = pwd.length();
        if (len >= 6 && len <= 12) {
            mIRegisterView.setValidatePwdResult(true);
        } else {
            mIRegisterView.setValidatePwdResult(false);
        }
    }

    /**
     * 验证再次输入的密码
     *
     * @param repwd
     */
    public void validateRePwd(String pwd, String repwd) {
        if (pwd.equals(repwd)) {
            mIRegisterView.setValidateRePwdResult(true);
        } else {
            mIRegisterView.setValidateRePwdResult(false);
        }
    }

    /**
     * 注册
     *
     * @param name
     * @param mobile
     * @param code
     * @param pwd
     */
    public void register(String name, String mobile, String code, String pwd) {
        mRegisterActivityMode.register(name, mobile, code, pwd, this);
    }
}
