package com.louis.agricultural.ui.activity.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.louis.agricultural.presenter.LoginPresenter;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.ui.view.ILoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 登录
 */
public class LoginActivity extends MVPBaseActivity<ILoginView, LoginPresenter> implements ILoginView{

    @Bind(R.id.tv_register)
    TextView mTvRegister;
    @Bind(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        initTitle("登录");
        initEvent();
    }

    private void initEvent() {
        mTvRegister.setOnClickListener(this);
        mTvForgetPwd.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {
        switch (view.getId()){
            case R.id.tv_register:
                toRegister();
                break;
            case R.id.tv_forget_pwd:
                toFindPwd();
                break;
        }

    }

    private void toFindPwd() {
        Intent intent = new Intent(this, ForgetPasswordActivity.class);
        startActivity(intent);
    }

    private void toRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }




}
