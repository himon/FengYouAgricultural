package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.SearchActivityMode;

/**
 * Created by lc on 16/3/8.
 */
public class SearchActivityModeImpl extends BaseMode implements SearchActivityMode{

    private Activity mActivity;

    public SearchActivityModeImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void getSearchGoods(String category_id, String bankid, String search, String paixu, UserLoseMultiLoadedListener listener) {
        mManager.getSearchGoods(category_id, bankid, search, paixu, listener, null, mActivity);
    }
}
