package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.ForgetPasswordNextPresenter;

/**
 * Created by lc on 16/3/2.
 */
public interface ForgetPasswordActivityMode {

    /**
     * 修改密码
     *
     * @param user_id
     * @param user_pass
     * @param
     */
    void userUpdatePass(String user_id, String user_pass, String new_pass, UserLoseMultiLoadedListener listener);
}
