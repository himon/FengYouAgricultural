package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;

/**
 * Created by lc on 16/3/10.
 */
public interface AnnouncementFragmentMode {
    void getNewsList(String category_id, int page, UserLoseMultiLoadedListener listener);
}
