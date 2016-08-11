package com.louis.agricultural.model.mode.impl;


import android.support.v4.app.Fragment;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.HomeFragmentMode;

/**
 * Created by lc on 16/2/29.
 */
public class HomeFragmentModeImpl extends BaseMode implements HomeFragmentMode{

    private Fragment mFragment;

    public HomeFragmentModeImpl(Fragment fragment) {
        mFragment = fragment;
    }

    @Override
    public void getIndexImage(int top, UserLoseMultiLoadedListener listener) {
        mManager.getIndexImage(top, listener, mFragment);
    }

    @Override
    public void getIndexFytt(int top, UserLoseMultiLoadedListener listener) {
        mManager.getIndexFytt(top, listener, mFragment);
    }

    @Override
    public void getIndexFytj(int top, UserLoseMultiLoadedListener listener) {
        mManager.getIndexFytj(top, listener, mFragment);
    }

    @Override
    public void getIndexRmtj(int top, UserLoseMultiLoadedListener listener) {
        mManager.getIndexRmtj(top, listener, mFragment);
    }

    @Override
    public void getGoodsbank(String category_id, UserLoseMultiLoadedListener listener) {
        mManager.getGoodsbank12(category_id, listener, mFragment);
    }
}
