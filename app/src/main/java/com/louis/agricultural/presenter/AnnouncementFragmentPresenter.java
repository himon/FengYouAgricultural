package com.louis.agricultural.presenter;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.AnnouncementFragmentMode;
import com.louis.agricultural.model.mode.impl.AnnouncementFragmentModeImpl;
import com.louis.agricultural.ui.fragment.message.AnnouncementFragment;
import com.louis.agricultural.ui.view.IAnnouncementView;

/**
 * Created by lc on 16/3/10.
 */
public class AnnouncementFragmentPresenter extends UserLosePresenter<IAnnouncementView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IAnnouncementView mIAnnouncementView;
    private AnnouncementFragmentMode mAnnouncementFragmentMode;

    public AnnouncementFragmentPresenter(IAnnouncementView view) {
        mIAnnouncementView = view;
        mAnnouncementFragmentMode = new AnnouncementFragmentModeImpl((Fragment)view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.GET_NEWS_LIST_LISTENER:
                mIAnnouncementView.setData(data);
                break;
        }
    }

    public void getNewsList(String category_id, int page) {
        if("56".equals(category_id)) {
            mAnnouncementFragmentMode.getNewsListAnnouncement(category_id, page, this);
        }else if("57".equals(category_id)){
            mAnnouncementFragmentMode.getNewsListNews(category_id, page, this);
        }else if("58".equals(category_id)){
            mAnnouncementFragmentMode.getNewsListDistribution(category_id, page, this);
        }
    }
}
