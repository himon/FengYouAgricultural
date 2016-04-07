package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.UserInfoActivityPresenter;

/**
 * Created by lc on 16/3/2.
 */
public interface UserInfoActivityMode {
    void getUserInfomation(String id, UserLoseMultiLoadedListener listener);

    void getUserImg(String user_id, UserLoseMultiLoadedListener listener);

    void uploadImg(String user_id, String base64, UserLoseMultiLoadedListener listener);

    void userUpuserinformation(String user_id, String strxgname, String nick_name, UserLoseMultiLoadedListener listener);
}
