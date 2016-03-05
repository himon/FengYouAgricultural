package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.LoginPresenter;

/**
 * Created by lc on 16/3/1.
 */
public interface LoginActivityMode {

    /**
     * 登陆
     *
     * @param user_name
     * @param user_pass
     * @param listener
     */
    void login(String user_name, String user_pass, UserLoseMultiLoadedListener listener);
}
