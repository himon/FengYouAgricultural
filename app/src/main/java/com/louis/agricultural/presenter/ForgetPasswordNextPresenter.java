package com.louis.agricultural.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.ForgetPasswordActivityMode;
import com.louis.agricultural.model.mode.impl.ForgetPasswordActivityModeImpl;
import com.louis.agricultural.ui.activity.account.ForgetPasswordActivity;
import com.louis.agricultural.ui.view.IForgetPasswordNextView;

/**
 * Created by lc on 16/3/2.
 */
public class ForgetPasswordNextPresenter extends UserLosePresenter<IForgetPasswordNextView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IForgetPasswordNextView mIForgetPasswordNextView;
    private ForgetPasswordActivityMode mForgetPasswordActivityMode;

    public ForgetPasswordNextPresenter(IForgetPasswordNextView view) {
        mIForgetPasswordNextView = view;
        mForgetPasswordActivityMode = new ForgetPasswordActivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.USER_UPDATEPASS_LISTENER:
                mIForgetPasswordNextView.updateSuccess(data);
                break;
        }
    }

    public void validatePwd(String pwd) {
        int length = pwd.length();
        if (length >= 6 && length <= 12) {
            mIForgetPasswordNextView.validatePwdResult(true);
        } else {
            mIForgetPasswordNextView.validatePwdResult(false);
        }
    }

    public void validateRePwd(String pwd, String repwd) {
        if (pwd.equals(repwd)) {
            mIForgetPasswordNextView.validateRePwdResult(true);
        }else{
            mIForgetPasswordNextView.validateRePwdResult(false);
        }
    }

    public void validateOldPwd(String pwd) {
        int length = pwd.length();
        if (length >= 6 && length <= 12) {
            mIForgetPasswordNextView.validateOldPwdResult(true);
        } else {
            mIForgetPasswordNextView.validateOldPwdResult(false);
        }
    }

    public void updatePwd(String user_id, String user_pass, String new_pass, String repwd) {
        if(TextUtils.isEmpty(new_pass) || TextUtils.isEmpty(repwd) || TextUtils.isEmpty(user_pass)){

        }else{
            if(new_pass.equals(repwd)){
                mForgetPasswordActivityMode.userUpdatePass(user_id, user_pass, new_pass, this);
            }
        }
    }


}
