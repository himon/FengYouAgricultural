package com.louis.agricultural.presenter;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.ProductFirstFragmentMode;
import com.louis.agricultural.model.mode.impl.ProductFirstFragmentModeImpl;
import com.louis.agricultural.ui.view.IProductFirstFragmentView;

public class ProductFirstFragmentPresenter extends UserLosePresenter<IProductFirstFragmentView>
        implements UserLoseMultiLoadedListener<BaseEntity> {
    private IProductFirstFragmentView mIProductFirstFragmentView;
    private ProductFirstFragmentMode mProductFirstFragmentMode;

    public ProductFirstFragmentPresenter(IProductFirstFragmentView paramIProductFirstFragmentView) {
        this.mIProductFirstFragmentView = paramIProductFirstFragmentView;
        this.mProductFirstFragmentMode = new ProductFirstFragmentModeImpl((Fragment) paramIProductFirstFragmentView);
    }

    public void getAddGoodscart(String paramString1, String paramString2, String paramString3) {
        this.mProductFirstFragmentMode.getAddGoodscart(paramString1, paramString2, paramString3, this);
    }

    public void onSuccess(int paramInt, BaseEntity paramBaseEntity) {
        switch (paramInt) {
            case Constants.GET_ADD_GOODSCART_LISTENER:
                this.mIProductFirstFragmentView.addSuccess(paramBaseEntity);
                break;
            default:
                return;
        }

    }
}