package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.OrderDetailActivityMode;

/**
 * Created by Administrator on 2016/4/11.
 */
public class OrderDetailActivityModeImpl extends BaseMode implements OrderDetailActivityMode {

    private Activity mActivity;

    public OrderDetailActivityModeImpl(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void getOrderShow(String order_id, UserLoseMultiLoadedListener listener) {
        mManager.getOrderShow(order_id, listener, mActivity);
    }

    @Override
    public void updateOrder(String orderId, String strxgname, String strzhi, UserLoseMultiLoadedListener listener) {
        mManager.updateOrder(orderId, strxgname, strzhi, listener, mActivity);
    }
}
