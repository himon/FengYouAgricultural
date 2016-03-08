package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.ShoppingAddressActivityMode;
import com.louis.agricultural.ui.view.IShoppingAddressView;

/**
 * Created by lc on 16/3/8.
 */
public class ShoppingAddressActivityModeImpl extends BaseMode implements ShoppingAddressActivityMode {

    private Activity mActivity;

    public ShoppingAddressActivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void getAdress(String user_id, UserLoseMultiLoadedListener listener) {
        mManager.getAdress(user_id, listener, mActivity);
    }
}
