package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.model.mode.SearchActivityMode;
import com.louis.agricultural.model.mode.impl.SearchActivityModeImpl;
import com.louis.agricultural.ui.activity.SearchActivity;
import com.louis.agricultural.ui.view.ISearchView;

/**
 * Created by lc on 16/3/8.
 */
public class SearchActivityPresenter extends UserLosePresenter<ISearchView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private ISearchView mISearchView;
    private SearchActivityMode mSearchActivityMode;

    public SearchActivityPresenter(ISearchView view) {
        mISearchView = view;
        mSearchActivityMode = new SearchActivityModeImpl((Activity)view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_SEARCH_GOODS_LISTENER:
                mISearchView.setProducts((ProductEntity)data);
                break;
        }
    }

    public void getSearchGoods(String category_id, String search, String paixu) {
        mSearchActivityMode.getSearchGoods(category_id, "0", search, paixu, this);
    }
}
