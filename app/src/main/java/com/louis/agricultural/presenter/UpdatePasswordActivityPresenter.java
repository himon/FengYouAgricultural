package com.louis.agricultural.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.UpdatePasswordActivityMode;
import com.louis.agricultural.model.mode.impl.UpdatePasswordActivityModeImpl;
import com.louis.agricultural.ui.activity.me.UpdatePasswordActivity;
import com.louis.agricultural.ui.view.IUpdatePasswordView;
import com.louis.agricultural.utils.ShowToast;

/**
 * Created by lc on 16/3/16.
 */
public class UpdatePasswordActivityPresenter extends UserLosePresenter<IUpdatePasswordView> implements UserLoseMultiLoadedListener<BaseEntity> {


    private IUpdatePasswordView mIUpdatePasswordView;
    private UpdatePasswordActivityMode mUpdatePasswordActivityMode;

    public UpdatePasswordActivityPresenter(IUpdatePasswordView view) {
        mIUpdatePasswordView = view;
        mUpdatePasswordActivityMode = new UpdatePasswordActivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.USER_UPDATEPASS_LISTENER:
                mIUpdatePasswordView.updateSuccess(data);
                break;
        }
    }

    /**
     * 修改密码
     *
     * @param user_id
     * @param user_pass
     * @param new_pass
     * @param new_repass
     */
    public void userUpdatePass(String user_id, String user_pass, String new_pass, String new_repass) {
        if (TextUtils.isEmpty(user_pass)) {
            ShowToast.Short("请输入原始密码!");
            return;
        }

        if (TextUtils.isEmpty(new_pass)) {
            ShowToast.Short("请输入新密码!");
            return;
        }

        if(!new_pass.equals(new_repass)){
            ShowToast.Short("两次输入的密码不一致!");
            return;
        }

        mUpdatePasswordActivityMode.userUpdatePass(user_id, user_pass, new_pass, this);
    }
}
