package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.MyOrderPresenter;

/**
 * Created by lc on 16/3/24.
 */
public interface MyOrderActivityMode {
    void updateOrder(String orderId, String strxgname, String strzhi, UserLoseMultiLoadedListener listener);
}
