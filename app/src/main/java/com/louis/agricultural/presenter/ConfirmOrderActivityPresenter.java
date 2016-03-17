package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.mode.ConfirmOrderActivityMode;
import com.louis.agricultural.model.mode.impl.ConfirmOrderActivityModeImpl;
import com.louis.agricultural.ui.activity.me.ConfirmOrderActivity;
import com.louis.agricultural.ui.view.IConfirmOrderView;

import java.util.ArrayList;

/**
 * Created by lc on 16/3/10.
 */
public class ConfirmOrderActivityPresenter extends UserLosePresenter<IConfirmOrderView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IConfirmOrderView mIConfirmOrderView;
    private ConfirmOrderActivityMode mConfirmOrderActivityMode;

    public ConfirmOrderActivityPresenter(IConfirmOrderView view) {
        mIConfirmOrderView = view;
        mConfirmOrderActivityMode = new ConfirmOrderActivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.ADD_ORDER_LISTENER:
                mIConfirmOrderView.setCreateSuccess(data);
                break;
            case Constants.GET_DEFAULT_ADRESS_LISTENER:
                mIConfirmOrderView.setDefaultAddress((ShoppingAddressEntity)data);
                break;
        }
    }

    /**
     * 添加商品订单
     *
     * @param user_id
     * @param adress_id
     * @param message
     * @param user_name
     * @param list
     */
    public void addOrder(String user_id, String adress_id, String message, String user_name, ArrayList<ShoppingCartEntity.ResultEntity> list) {
        mConfirmOrderActivityMode.addOrder(user_id, adress_id, message, user_name, list, this);
    }

    /**
     * 获取个人默认收货地址
     * @param user_id
     */
    public void getDefaultAdress(String user_id) {
        mConfirmOrderActivityMode.getDefaultAdress(user_id, this);
    }
}
