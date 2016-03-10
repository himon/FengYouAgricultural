package com.louis.agricultural.model.mode.impl;

import android.support.v4.app.Fragment;

import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.AnnouncementFragmentMode;

/**
 * Created by lc on 16/3/10.
 */
public class AnnouncementFragmentModeImpl extends BaseMode implements AnnouncementFragmentMode {

    private Fragment mFragment;

    public AnnouncementFragmentModeImpl(Fragment fragment) {
        mFragment = fragment;
    }


    @Override
    public void getNewsList(String category_id, int page, UserLoseMultiLoadedListener listener) {
        mManager.getNewsList(category_id, page, listener, mFragment);
    }
}
