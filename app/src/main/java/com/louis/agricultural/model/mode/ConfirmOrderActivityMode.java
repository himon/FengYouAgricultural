package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.presenter.ConfirmOrderActivityPresenter;

import java.util.ArrayList;

/**
 * Created by lc on 16/3/10.
 */
public interface ConfirmOrderActivityMode {
    void addOrder(String user_id, String adress_id, String message, String user_name, ArrayList<ShoppingCartEntity.ResultEntity> list, UserLoseMultiLoadedListener listener);

    void getDefaultAdress(String user_id, UserLoseMultiLoadedListener listener);
}
