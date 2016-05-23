package com.louis.agricultural.presenter;


import android.support.v4.app.Fragment;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BankEntity;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ClassifyEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.model.mode.ClassifyFragmentMode;
import com.louis.agricultural.model.mode.impl.ClassifyFragmentModeImpl;
import com.louis.agricultural.ui.view.IClassifyView;

/**
 * Created by lc on 16/3/6.
 */
public class ClassifyFragmentPresenter extends UserLosePresenter<IClassifyView> implements UserLoseMultiLoadedListener<BaseEntity>{

    private IClassifyView mIClassifyView;
    private ClassifyFragmentMode mClassifyFragmentMode;
    private String mId;

    public ClassifyFragmentPresenter(IClassifyView view) {
        mIClassifyView = view;
        mClassifyFragmentMode = new ClassifyFragmentModeImpl((Fragment) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_CATEGORY_LISTENER:
                if("0".equals(mId)) {
                    mIClassifyView.setClassify((ClassifyEntity) data);
                }else{
                    mIClassifyView.setSecondClassify((ClassifyEntity) data);
                }
                break;
            case Constants.GET_SEARCH_GOODS_LISTENER:
                mIClassifyView.setProducts((ProductEntity)data);
                break;
            case Constants.GET_GOODSBANK_LISTENER:
                mIClassifyView.setGoodsBank((BankEntity)data);
                break;
        }
    }

    @Override
    public void onError(String msg) {

    }

    public void getCategory(String category_parentid) {
        mId = category_parentid;
        mClassifyFragmentMode.getCategory(category_parentid, this);
    }

    public void getSearchGoods(String category_id, String bankid, String search, String paixu) {
        mClassifyFragmentMode.getSearchGoods(category_id, bankid, search, paixu, this);
    }

    public void getGoodsbank(String bankid)
    {
        mClassifyFragmentMode.getGoodsbank(bankid, this);
    }
}
