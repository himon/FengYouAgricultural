package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.mode.ProductDetailsActivityMode;
import com.louis.agricultural.model.mode.impl.ProductDetailsActivityModeImpl;
import com.louis.agricultural.ui.activity.ProductDetailsActivity;
import com.louis.agricultural.ui.view.IProductDetailsView;
import com.louis.agricultural.utils.ShowToast;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/1/23 15:11
 * @des
 */
public class ProductDetailsPresenter extends UserLosePresenter<IProductDetailsView> implements UserLoseMultiLoadedListener<BaseEntity>{

    private IProductDetailsView mIProductDetailsView;
    private ProductDetailsActivityMode mProductDetailsActivityMode;

    public ProductDetailsPresenter(IProductDetailsView view) {
        mIProductDetailsView = view;
        mProductDetailsActivityMode = new ProductDetailsActivityModeImpl((Activity)view);
    }

    public void getGoodsShow(String article_id) {
        mProductDetailsActivityMode.getGoodsShow(article_id, this);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_GOODS_SHOW_LISTENER:
                mIProductDetailsView.setDetail((ProductDetailEntity)data);
                break;
            case Constants.GET_ADD_GOODSCART_LISTENER:
                mIProductDetailsView.addSuccess(data);
                break;
        }
    }

    public void getAddGoodscart(String user_id, String goods_id, int sum) {
        mProductDetailsActivityMode.getAddGoodscart(user_id, goods_id, sum, this);
    }
}
