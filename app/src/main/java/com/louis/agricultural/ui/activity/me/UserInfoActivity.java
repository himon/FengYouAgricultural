package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 个人中心
 */
public class UserInfoActivity extends BaseActivity {

    @Bind(R.id.ll_update_pwd)
    LinearLayout mLLUpdatePwd;
    @Bind(R.id.ll_shipping_address)
    LinearLayout mLLShippingAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

        initEvent();
    }

    private void initEvent() {
        mLLUpdatePwd.setOnClickListener(this);
        mLLShippingAddress.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.ll_update_pwd:
                toUpdatePwd();
                break;
            case R.id.ll_shipping_address:
                toShippingAddress();
                break;
        }
    }

    private void toShippingAddress() {
        Intent intent = new Intent(this, ShippingAddressActivity.class);
        startActivity(intent);
    }

    private void toUpdatePwd() {
        Intent intent = new Intent(this, UpdatePasswordActivity.class);
        startActivity(intent);
    }
}
