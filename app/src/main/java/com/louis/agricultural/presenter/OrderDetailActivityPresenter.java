package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.OrderDetailEntity;
import com.louis.agricultural.model.mode.OrderDetailActivityMode;
import com.louis.agricultural.model.mode.impl.OrderDetailActivityModeImpl;
import com.louis.agricultural.ui.activity.me.OrderDetailActivity;
import com.louis.agricultural.ui.view.IOrderDetailView;

/**
 * Created by Administrator on 2016/4/11.
 */
public class OrderDetailActivityPresenter extends UserLosePresenter<IOrderDetailView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IOrderDetailView mIOrderDetailView;
    private OrderDetailActivityMode mOrderDetailActivityMode;

    public OrderDetailActivityPresenter(IOrderDetailView iOrderDetailView){
        mIOrderDetailView = iOrderDetailView;
        mOrderDetailActivityMode = new OrderDetailActivityModeImpl((Activity)iOrderDetailView);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_ORDER_SHOW_LISTENER:
                mIOrderDetailView.setData((OrderDetailEntity)data);
                break;
            case Constants.UPDATE_ORDER_LISTENER:
                mIOrderDetailView.setUpdateOrderSuccess(data);
                break;
        }
    }

    public void getOrderShow(String order_id) {
        mOrderDetailActivityMode.getOrderShow(order_id, this);
    }

    public void updateOrder(String orderId, String strxgname, String strzhi) {
        mOrderDetailActivityMode.updateOrder(orderId, strxgname, strzhi, this);
    }
}
