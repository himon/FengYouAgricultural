package com.louis.agricultural.presenter;

import android.support.v4.app.Fragment;

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

    }

    public void getNewsList(String category_id, int page) {
        mAnnouncementFragmentMode.getNewsList(category_id, page, this);
    }
}
