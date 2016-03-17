package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.mode.ConfirmOrderActivityMode;

import java.util.ArrayList;

/**
 * Created by lc on 16/3/10.
 */
public class ConfirmOrderActivityModeImpl extends BaseMode implements ConfirmOrderActivityMode {

    private Activity mActivity;

    public ConfirmOrderActivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void addOrder(String user_id, String adress_id, String message, String user_name, ArrayList<ShoppingCartEntity.ResultEntity> list, UserLoseMultiLoadedListener listener) {
        mManager.addOrder(user_id, adress_id, message, user_name, list, listener, mActivity);
    }

    @Override
    public void getDefaultAdress(String user_id, UserLoseMultiLoadedListener listener) {
        mManager.getDefaultAdress(user_id, listener, mActivity);
    }
}
