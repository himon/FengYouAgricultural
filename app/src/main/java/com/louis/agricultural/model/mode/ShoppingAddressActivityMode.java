package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.ShoppingAddressActivityPresenter;

/**
 * Created by lc on 16/3/8.
 */
public interface ShoppingAddressActivityMode {
    void getAdress(String user_id, UserLoseMultiLoadedListener listener);
}
