package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;

/**
 * Created by lc on 16/3/16.
 */
public interface UpdatePasswordActivityMode {
    void userUpdatePass(String user_id, String user_pass, String new_pass, UserLoseMultiLoadedListener listener);
}
