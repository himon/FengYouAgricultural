package com.louis.agricultural.model.mode.impl;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.ShoppingCartFragmentMode;

/**
 * Created by lc on 16/3/7.
 */
public class ShoppingCartFragmentModeImpl extends BaseMode implements ShoppingCartFragmentMode {

    private Fragment mFragment;

    public ShoppingCartFragmentModeImpl(Fragment fragment) {
        mFragment = fragment;
    }


    @Override
    public void getGoodsCart(String user_id, UserLoseMultiLoadedListener listener) {
        mManager.getGoodsCart(user_id, listener, mFragment);
    }

    @Override
    public void deleteGoodscart(String car_id, UserLoseMultiLoadedListener listener) {
        mManager.deleteGoodscart(car_id, listener, mFragment);
    }
}
