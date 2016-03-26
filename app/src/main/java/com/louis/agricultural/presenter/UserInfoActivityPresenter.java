package com.louis.agricultural.presenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.UserInfoActivityMode;
import com.louis.agricultural.model.mode.impl.UserInfoactivityModeImpl;
import com.louis.agricultural.ui.activity.me.UserInfoActivity;
import com.louis.agricultural.ui.view.IUserInfoView;
import com.louis.agricultural.utils.Base64Utils;
import com.louis.agricultural.utils.ShowToast;

/**
 * Created by lc on 16/3/2.
 */
public class UserInfoActivityPresenter extends UserLosePresenter<IUserInfoView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IUserInfoView mIUserInfoView;
    private UserInfoActivityMode mUserInfoActivityMode;

    public UserInfoActivityPresenter(IUserInfoView view) {
        mIUserInfoView = view;
        mUserInfoActivityMode = new UserInfoactivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag) {
            case Constants.UPLOAD_IMG_LISTENER:
                mIUserInfoView.updateSuccess(data);
                break;
            case Constants.GET_USERIMG_LISTENER:
                mIUserInfoView.setUserImg(data);
                break;
        }

    }

    public void getUserInfomation(String id) {
        mUserInfoActivityMode.getUserInfomation(id, this);
    }

    public void getUserImg(String user_id) {
        mUserInfoActivityMode.getUserImg(user_id, this);
    }

    public void uploadImg(String user_id, Intent data) {
        if (data != null) {
            byte[] bis = data.getByteArrayExtra(Constants.MESSAGE_EXTRA_KEY2);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bis, 0, bis.length);
            String base64 = Base64Utils.bitmapToBase64(bitmap);
            mUserInfoActivityMode.uploadImg(user_id, base64, this);
        }
    }
}
