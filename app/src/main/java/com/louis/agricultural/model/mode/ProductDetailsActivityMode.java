package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.ProductDetailsPresenter;

/**
 * Created by lc on 16/3/6.
 */
public interface ProductDetailsActivityMode {
    void getGoodsShow(String article_id, UserLoseMultiLoadedListener listenter);

    void getAddGoodscart(String user_id, String goods_id, int sum, UserLoseMultiLoadedListener listenter);
}
