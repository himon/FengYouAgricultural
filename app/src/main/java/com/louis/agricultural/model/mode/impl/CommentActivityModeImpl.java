package com.louis.agricultural.model.mode.impl;

import android.app.Activity;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.CommentActivityMode;

/**
 * Created by Administrator on 2016/4/11.
 */
public class CommentActivityModeImpl extends BaseMode implements CommentActivityMode{

    private Activity mActivity;

    public CommentActivityModeImpl(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void addGoodsComment(String goods_id, String user_id, String user_name, String conment, String order_goods_id, UserLoseMultiLoadedListener listener) {
        mManager.addGoodsComment(goods_id, user_id, user_name, conment, order_goods_id, listener, mActivity);
    }
}
