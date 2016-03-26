package com.louis.agricultural.model.mode.impl;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.MyOrderFragmentMode;

/**
 * Created by lc on 16/3/10.
 */
public class MyOrderFragmentModeImpl extends BaseMode implements MyOrderFragmentMode {

    private Fragment mFragment;

    public MyOrderFragmentModeImpl(Fragment fragment) {
        mFragment = fragment;
    }

    @Override
    public void getOrderList(String user_id, int page, String status, String payment_status, String express_status, UserLoseMultiLoadedListener listener) {
        mManager.getOrderList(user_id, page, status, payment_status, express_status, listener, mFragment);
    }
}
