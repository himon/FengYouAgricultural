package com.louis.agricultural.base.activity;

import android.os.Bundle;

import com.louis.agricultural.base.presenter.BasePresenter;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2015/12/18 16:44
 * @des
 */
public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends BaseActivity {

    /**
     * Presenter对象
     */
    protected T mMPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMPresenter = createPresenter();
        mMPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
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

