package com.louis.agricultural.presenter;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.mode.MyOrderFragmentMode;
import com.louis.agricultural.model.mode.impl.MyOrderFragmentModeImpl;
import com.louis.agricultural.ui.fragment.MyOrderFragment;
import com.louis.agricultural.ui.view.IMyOrderView;

/**
 * Created by lc on 16/3/10.
 */
public class MyOrderFragmentPresenter extends UserLosePresenter<IMyOrderView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IMyOrderView mIMyOrderView;
    private MyOrderFragmentMode mMyOrderFragmentMode;

    public MyOrderFragmentPresenter(IMyOrderView view) {
        mIMyOrderView = view;
        mMyOrderFragmentMode = new MyOrderFragmentModeImpl((Fragment) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_ORDER_LIST_LISTENER:
                mIMyOrderView.setData((OrderEntity)data);
                break;
        }
    }

    /**
     * 查看个人商品订单
     * @param user_id
     * @param page
     * @param status
     * @param payment_status
     * @param express_status
     */
    public void getOrderList(String user_id, int page, String status, String payment_status, String express_status) {
        mMyOrderFragmentMode.getOrderList(user_id, page, status, payment_status, express_status, this);
    }
}
