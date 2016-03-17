package com.louis.agricultural.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.louis.agricultural.BuildConfig;
import com.louis.agricultural.R;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.utils.manager.ActivityManager;
import com.louis.agricultural.utils.logger.LogLevel;
import com.louis.agricultural.utils.logger.Logger;
import com.zhy.autolayout.AutoLayoutActivity;


public abstract class BasicActivity extends AutoLayoutActivity implements View.OnClickListener {


    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        ActivityManager.getAppManager().addActivity(this);

        if (BuildConfig.DEBUG) {
            Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.FULL).hideThreadInfo();
        } else {
            Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.NONE).hideThreadInfo();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Abstract Method In Activity
    ///////////////////////////////////////////////////////////////////////////

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void click(View view);

    ///////////////////////////////////////////////////////////////////////////
    // Common Operation
    ///////////////////////////////////////////////////////////////////////////


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getAppManager().finishActivity(this);
        FYApplication.getRefWatcher(this).watch(this);
        //RequestManager.cancelAll(this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_none, R.anim.trans_center_2_right);
    }

    protected void back() {
        hideKeyboard();
        finish();
    }

    /**
     * 隐藏软键盘
     */
    public void hideKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null) {
                InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_nav_left:
                back();
                break;
        }
        click(v);
    }
}
