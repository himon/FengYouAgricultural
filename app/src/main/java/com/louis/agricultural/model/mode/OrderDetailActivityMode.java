package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.OrderDetailActivityPresenter;

/**
 * Created by Administrator on 2016/4/11.
 */
public interface OrderDetailActivityMode {
    void getOrderShow(String order_id, UserLoseMultiLoadedListener listener);

    void updateOrder(String orderId, String strxgname, String strzhi, UserLoseMultiLoadedListener listener);
}
