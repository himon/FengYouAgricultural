package com.louis.agricultural.ui.activity.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.ProductDetailEvent;
import com.louis.agricultural.presenter.LoginPresenter;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.ui.view.ILoginView;
import com.louis.agricultural.utils.JsonUtil;
import com.louis.agricultural.utils.PreferencesUtils;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 登录
 */
public class LoginActivity extends MVPBaseActivity<ILoginView, LoginPresenter> implements ILoginView {

    @Bind(R.id.et_name)
    EditText mEtName;
    @Bind(R.id.et_pwd)
    EditText mEtPwd;
    @Bind(R.id.tv_register)
    TextView mTvRegister;
    @Bind(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @Bind(R.id.btn_login)
    Button mBtnLogin;

    private LoginPresenter mPresenter;
    private String mFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("登录");
        initEvent();
    }

    private void initEvent() {
        mTvRegister.setOnClickListener(this);
        mTvForgetPwd.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mFrom = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                toRegister();
                break;
            case R.id.tv_forget_pwd:
                toFindPwd();
                break;
            case R.id.btn_login:

                mPresenter.login(mEtName.getText().toString().trim(), mEtPwd.getText().toString().trim());
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


    @Override
    public void loginSuccess(UserEntity data) {
        ShowToast.Short(data.getMessage());

        String str = JsonUtil.toJson(data);
        PreferencesUtils.putString(this, "User", str);

        FYApplication.getContext().setUserEntity(data);
        if (!TextUtils.isEmpty(mFrom)) {
            EventBus.getDefault().post(new LoginResultEvent(mFrom));
        }
        if(Constants.LOGIN_REFRESH_BY_PRODUCT_DETAIL.equals(mFrom)){
            EventBus.getDefault().post(new ProductDetailEvent("refresh_shopping_cart"));
        }
        back();
    }
}
