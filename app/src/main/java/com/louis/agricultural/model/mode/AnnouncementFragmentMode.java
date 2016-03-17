package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.AnnouncementFragmentPresenter;

/**
 * Created by lc on 16/3/10.
 */
public interface AnnouncementFragmentMode {
    void getNewsListAnnouncement(String category_id, int page, UserLoseMultiLoadedListener listener);

    void getNewsListDistribution(String category_id, int page, UserLoseMultiLoadedListener listener);

    void getNewsListNews(String category_id, int page, UserLoseMultiLoadedListener listener);
}
