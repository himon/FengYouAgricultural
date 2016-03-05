package com.louis.agricultural.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.presenter.BasePresenter;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2015/12/18 16:44
 * @des
 */
public abstract class MVPBaseFragment<V, T extends BasePresenter<V>> extends BaseFragment {

    /**
     * Presenter对象
     */
    protected T mMPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMPresenter = createPresenter();
        mMPresenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMPresenter.detachView();
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract T createPresenter();
}

