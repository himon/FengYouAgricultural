package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.SearchActivityPresenter;

/**
 * Created by lc on 16/3/8.
 */
public interface SearchActivityMode {
    void getSearchGoods(String category_id, String bankid, String search, String paixu, UserLoseMultiLoadedListener listener);
}
