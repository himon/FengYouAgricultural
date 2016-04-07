package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.UpdateUserInfoActivityPresenter;

/**
 * Created by lc on 16/4/6.
 */
public interface UpdateUserInfoActivityMode {
    void userUpuserinformation(String user_name, String nick_name, String strzhi, UserLoseMultiLoadedListener listener);
}
