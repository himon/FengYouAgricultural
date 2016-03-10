package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * 订单详情
 */
public class OrderDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {

    }

}
