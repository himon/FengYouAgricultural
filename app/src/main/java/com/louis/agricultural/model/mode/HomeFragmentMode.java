package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.HomePresenter;

/**
 * Created by lc on 16/2/29.
 */
public interface HomeFragmentMode {
    void getIndexImage(int top, UserLoseMultiLoadedListener listener);

    void getIndexFytt(int top, UserLoseMultiLoadedListener listener);

    void getIndexFytj(int top, UserLoseMultiLoadedListener listener);

    void getIndexRmtj(int top, UserLoseMultiLoadedListener listener);
}
