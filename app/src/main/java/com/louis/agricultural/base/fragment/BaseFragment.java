package com.louis.agricultural.base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.louis.agricultural.BuildConfig;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.utils.logger.LogLevel;
import com.louis.agricultural.utils.logger.Logger;
import com.louis.agricultural.utils.manager.ImageLoadProxy;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/1/23 15:48
 * @des
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.FULL).hideThreadInfo();
        } else {
            Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.NONE).hideThreadInfo();
        }
    }

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        FYApplication.getRefWatcher(getActivity()).watch(this);
        //RequestManager.cancelAll(this);
        ImageLoadProxy.getImageLoader().clearMemoryCache();
    }
}
