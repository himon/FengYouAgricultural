package com.louis.agricultural.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.UpdateUserInfoActivityMode;
import com.louis.agricultural.model.mode.impl.UpdateUserInfoActivityModeImpl;
import com.louis.agricultural.ui.activity.me.UpdateUserInfoActivity;
import com.louis.agricultural.ui.view.IUpdateUserInfoView;

/**
 * Created by lc on 16/4/6.
 */
public class UpdateUserInfoActivityPresenter extends UserLosePresenter<IUpdateUserInfoView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IUpdateUserInfoView mIUpdateUserInfoView;
    private UpdateUserInfoActivityMode mUpdateUserInfoActivityMode;

    public UpdateUserInfoActivityPresenter(IUpdateUserInfoView updateUserInfoActivity) {
        this.mIUpdateUserInfoView = updateUserInfoActivity;
        this.mUpdateUserInfoActivityMode = new UpdateUserInfoActivityModeImpl((Activity) updateUserInfoActivity);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.USER_UPUSERINFOMATION_LISTENER:
                mIUpdateUserInfoView.updateSuccess(data);
                break;
        }
    }

    public void userUpuserinformation(String user_id, String nick_name, String strxgname) {
        if (TextUtils.isEmpty(nick_name)) {
            return;
        }
        mUpdateUserInfoActivityMode.userUpuserinformation(user_id, strxgname, nick_name, this);
    }
}
