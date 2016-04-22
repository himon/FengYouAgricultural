package com.louis.agricultural.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.louis.agricultural.BuildConfig;
import com.louis.agricultural.R;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.utils.manager.ActivityManager;
import com.louis.agricultural.utils.logger.LogLevel;
import com.louis.agricultural.utils.logger.Logger;
import com.louis.agricultural.view.CustomerProgress;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.Bind;


public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener {

    @Bind(R.id.iv_nav_left)
    protected ImageView mNavLeft;
    @Bind(R.id.rl_nav_left)
    protected RelativeLayout mRlLeft;
    @Bind(R.id.iv_nav_right)
    protected ImageView mIvNavRight;
    @Bind(R.id.tv_nav_right)
    protected TextView mTvNavRight;
    @Bind(R.id.tv_nav_title)
    protected TextView mNavTitle;

    protected Context mContext;

    private CustomerProgress mCustomerProgress;

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

    protected void initTitle(String title) {
        mNavTitle.setText(title);
        mNavLeft.setOnClickListener(this);
        mRlLeft.setOnClickListener(this);
    }

    public void waittingDialog() {
        setTheme(android.R.style.Theme);
        mCustomerProgress = new CustomerProgress(this, "进行中,请稍后");
        mCustomerProgress.show();
    }

    public void stopCusDialog() {
        if (mCustomerProgress != null) {
            mCustomerProgress.dismiss();
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


//    public void startAnim(){
//        if(mProgress == null){
//            mProgress = new AVLoadingIndicatorView(this);
//        }
//        mProgress.setVisibility(View.VISIBLE);
//    }
//
//    public void stopAnim(){
//        mProgress.setVisibility(View.GONE);
//    }

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
            case R.id.rl_nav_left:
                back();
                break;
        }
        click(v);
    }
}
