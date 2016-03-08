package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.ProductDetailsActivityMode;

/**
 * Created by lc on 16/3/6.
 */
public class ProductDetailsActivityModeImpl extends BaseMode implements ProductDetailsActivityMode {

    private Activity mActivity;

    public ProductDetailsActivityModeImpl(Activity activity) {
        mActivity = activity;
    }


    @Override
    public void getGoodsShow(String article_id, UserLoseMultiLoadedListener listenter) {
        mManager.getGoodsShow(article_id, listenter, mActivity);
    }

    @Override
    public void getAddGoodscart(String user_id, String goods_id, int sum, UserLoseMultiLoadedListener listenter) {
        mManager.getAddGoodscart(user_id, goods_id, sum, listenter, mActivity);
    }
}
