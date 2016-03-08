package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.AddShoppingAddressActivityMode;

/**
 * Created by lc on 16/3/8.
 */
public class AddShoppingAddressActivityModeImpl extends BaseMode implements AddShoppingAddressActivityMode {

    private Activity mActivity;

    public AddShoppingAddressActivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void getAddAddress(String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status, UserLoseMultiLoadedListener listener) {
        mManager.getAddAddress(user_id, sheng, shi, qu, xiangxi, code, shr, phone, status, listener, mActivity);
    }
}
