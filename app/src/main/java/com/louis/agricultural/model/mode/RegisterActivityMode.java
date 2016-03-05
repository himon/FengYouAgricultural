package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.RegisterPresenter;

/**
 * Created by lc on 16/3/1.
 */
public interface RegisterActivityMode {

    /**
     * 验证账号是否注册
     *
     * @param username
     * @param listener
     */
    void existsMobile(String username, UserLoseMultiLoadedListener listener);

    /**
     * 注册
     *
     * @param name
     * @param mobile
     * @param code
     * @param pwd
     * @param registerPresenter
     */
    void register(String name, String mobile, String code, String pwd, UserLoseMultiLoadedListener listener);
}
