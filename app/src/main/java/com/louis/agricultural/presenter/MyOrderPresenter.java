package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.MyOrderActivityMode;
import com.louis.agricultural.model.mode.impl.MyOrderActivityModeImpl;
import com.louis.agricultural.ui.activity.me.MyOrderActivity;
import com.louis.agricultural.ui.view.IMyOrderAView;

/**
 * Created by lc on 16/3/24.
 */
public class MyOrderPresenter extends UserLosePresenter<IMyOrderAView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IMyOrderAView mIMyOrderAView;
    private MyOrderActivityMode mMyOrderActivityMode;

    public MyOrderPresenter(IMyOrderAView iMyOrderAView) {
        this.mIMyOrderAView = iMyOrderAView;
        this.mMyOrderActivityMode = new MyOrderActivityModeImpl((Activity)iMyOrderAView);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.UPDATE_ORDER_LISTENER:

                break;
        }
    }

    public void updateOrder(String orderId, String strxgname, String strzhi) {
        mMyOrderActivityMode.updateOrder(orderId, strxgname, strzhi, this);
    }
}
