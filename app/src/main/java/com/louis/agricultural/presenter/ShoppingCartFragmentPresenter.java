package com.louis.agricultural.presenter;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.mode.ShoppingCartFragmentMode;
import com.louis.agricultural.model.mode.impl.ShoppingCartFragmentModeImpl;
import com.louis.agricultural.ui.fragment.tab.ShoppingCartFragment;
import com.louis.agricultural.ui.view.IShoppingCartView;

/**
 * Created by lc on 16/3/7.
 */
public class ShoppingCartFragmentPresenter extends UserLosePresenter<IShoppingCartView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IShoppingCartView mIShoppingCartView;
    private ShoppingCartFragmentMode mShoppingCartFragmentMode;

    public ShoppingCartFragmentPresenter(IShoppingCartView view) {
        mIShoppingCartView = view;
        mShoppingCartFragmentMode = new ShoppingCartFragmentModeImpl((Fragment)view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_GOODSCART_LISTENER:
                mIShoppingCartView.setShoppingCart((ShoppingCartEntity)data);
                break;
            case Constants.DELETE_GOODSCART_LISTENER:
                mIShoppingCartView.setDeleteSuccess(data);
                break;
        }
    }

    public void get_goodscart(String user_id) {
        mShoppingCartFragmentMode.getGoodsCart(user_id, this);
    }

    public void deleteGoodscart(String car_id) {
        mShoppingCartFragmentMode.deleteGoodscart(car_id, this);
    }
}
