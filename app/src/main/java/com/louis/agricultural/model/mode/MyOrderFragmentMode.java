package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.MyOrderFragmentPresenter;

/**
 * Created by lc on 16/3/10.
 */
public interface MyOrderFragmentMode {
    void getOrderList(String user_id, int page, String status, String payment_status, String express_status, UserLoseMultiLoadedListener listener);
}
