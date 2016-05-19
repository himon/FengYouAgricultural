package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.ClassifyFragmentPresenter;

/**
 * Created by lc on 16/3/6.
 */
public interface ClassifyFragmentMode {

    void getCategory(String category_parentid, UserLoseMultiLoadedListener listener);

    void getSearchGoods(String category_id, String bankid, String search, String paixu, UserLoseMultiLoadedListener listener);

    public abstract void getGoodsbank(String bankid, UserLoseMultiLoadedListener paramUserLoseMultiLoadedListener);
}
