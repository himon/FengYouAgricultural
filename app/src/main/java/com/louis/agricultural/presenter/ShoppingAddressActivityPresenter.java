package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.mode.ShoppingAddressActivityMode;
import com.louis.agricultural.model.mode.impl.ShoppingAddressActivityModeImpl;
import com.louis.agricultural.ui.activity.me.ShoppingAddressActivity;
import com.louis.agricultural.ui.view.IShoppingAddressView;

/**
 * Created by lc on 16/3/8.
 */
public class ShoppingAddressActivityPresenter extends UserLosePresenter<IShoppingAddressView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IShoppingAddressView mIShoppingAddressView;
    private ShoppingAddressActivityMode mShoppingAddressActivityMode;

    public ShoppingAddressActivityPresenter(IShoppingAddressView view) {
        mIShoppingAddressView = view;
        mShoppingAddressActivityMode = new ShoppingAddressActivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_ADRESS_LISTENER:
                mIShoppingAddressView.setShoppingAddressData((ShoppingAddressEntity)data);
                break;
        }
    }

    /**
     * 查看收货地址列表
     *
     * @param user_id
     */
    public void getAdress(String user_id) {
        mShoppingAddressActivityMode.getAdress(user_id, this);
    }
}
