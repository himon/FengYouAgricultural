package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * 支付页面
 */
public class PayActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        initTitle("支付");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {

    }
}
