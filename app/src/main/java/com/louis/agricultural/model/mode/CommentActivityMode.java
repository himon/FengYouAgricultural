package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.CommentActivityPresenter;

/**
 * Created by Administrator on 2016/4/11.
 */
public interface CommentActivityMode {
    void addGoodsComment(String goods_id, String user_id, String user_name, String conment, String order_goods_id, UserLoseMultiLoadedListener listener);
}
