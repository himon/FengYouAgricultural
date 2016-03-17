package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.ShoppingCartFragmentPresenter;

/**
 * Created by lc on 16/3/7.
 */
public interface ShoppingCartFragmentMode {

    void getGoodsCart(String user_id, UserLoseMultiLoadedListener listener);

    void deleteGoodscart(String car_id, UserLoseMultiLoadedListener listener);
}
