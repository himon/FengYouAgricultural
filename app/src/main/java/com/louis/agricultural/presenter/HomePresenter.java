package com.louis.agricultural.presenter;


import android.support.v4.app.Fragment;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.model.entities.FyttEntity;
import com.louis.agricultural.model.entities.HomeAdImageEntity;
import com.louis.agricultural.model.mode.HomeFragmentMode;
import com.louis.agricultural.model.mode.impl.HomeFragmentModeImpl;
import com.louis.agricultural.ui.view.IHomeView;


/**
 * Created by lc on 16/2/29.
 */
public class HomePresenter extends UserLosePresenter<IHomeView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IHomeView mIHomeView;
    private HomeFragmentMode mHomeFragmentMode;



    public HomePresenter(IHomeView view) {
        mIHomeView = view;
        mHomeFragmentMode = new HomeFragmentModeImpl((Fragment) view);
    }

    /**
     * 获取首页轮播图
     * @param top
     */
    public void getIndexImage(int top){
        mHomeFragmentMode.getIndexImage(top, this);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_INDEX_IMG_LISTENER:
                mIHomeView.setViewPagerAd((HomeAdImageEntity) data);
                break;
            case Constants.GET_INDEX_FYTT_LISTENER:
                mIHomeView.setFytt((FyttEntity) data);
                break;
            case Constants.GET_INDEX_JPTJ_LISTENER:
                mIHomeView.setFytj((ProductEntity) data);
                break;
            case Constants.GET_INDEX_RMTJ_LISTENER:
                mIHomeView.setRmtj((ProductEntity)data);
                break;
        }
    }

    /**
     * 丰友头条
     * @param top
     */
    public void getIndexFytt(int top) {
        mHomeFragmentMode.getIndexFytt(top, this);
    }

    /**
     * 精品推荐
     * @param top
     */
    public void getIndexFytj(int top) {
        mHomeFragmentMode.getIndexFytj(top, this);
    }

    /**
     * 热门推荐
     * @param top
     */
    public void getIndexFyrm(int top) {
        mHomeFragmentMode.getIndexRmtj(top, this);
    }
}
