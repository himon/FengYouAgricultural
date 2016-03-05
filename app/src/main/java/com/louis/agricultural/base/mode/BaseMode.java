package com.louis.agricultural.base.mode;

import com.louis.agricultural.utils.manager.HttpManager;

/**
 * Created by lc on 16/2/29.
 */
public class BaseMode {

    protected HttpManager mManager;

    public BaseMode() {
        this.mManager = new HttpManager();
    }
}
