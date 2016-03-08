package com.louis.agricultural.model.mode.impl;


import android.support.v4.app.Fragment;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.ClassifyFragmentMode;

/**
 * Created by lc on 16/3/6.
 */
public class ClassifyFragmentModeImpl extends BaseMode implements ClassifyFragmentMode {

    private Fragment mFragment;

    public ClassifyFragmentModeImpl(Fragment fragment) {
        mFragment = fragment;
    }

    @Override
    public void getCategory(String category_parentid, UserLoseMultiLoadedListener listener) {
        mManager.getCategory(category_parentid, listener, mFragment);
    }

    @Override
    public void getSearchGoods(String category_id, String search, String paixu, UserLoseMultiLoadedListener listener) {
        mManager.getSearchGoods(category_id, search, paixu, listener, mFragment, null);
    }
}
