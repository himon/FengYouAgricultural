package com.louis.agricultural.ui.activity.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForgetPasswordActivity extends BaseActivity {

    @Bind(R.id.btn_next_step)
    Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        initEvent();
    }

    private void initEvent() {
        mBtnNext.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {

        switch (view.getId()){
            case R.id.btn_next_step:
                next();
                break;
        }
    }

    private void next() {
        Intent intent = new Intent(this, ForgetPasswordNextActivity.class);
        startActivity(intent);
    }

}
