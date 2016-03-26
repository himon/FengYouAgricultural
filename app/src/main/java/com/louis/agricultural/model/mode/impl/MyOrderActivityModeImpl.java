package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.MyOrderActivityMode;

/**
 * Created by lc on 16/3/24.
 */
public class MyOrderActivityModeImpl extends BaseMode implements MyOrderActivityMode {

    private Activity mActivity;

    public MyOrderActivityModeImpl(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void updateOrder(String orderId, String strxgname, String strzhi, UserLoseMultiLoadedListener listener) {
        mManager.updateOrder(orderId, strxgname, strzhi, listener, mActivity);
    }
}
