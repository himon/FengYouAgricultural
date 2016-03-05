package com.louis.agricultural.ui.activity.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.presenter.RegisterPresenter;
import com.louis.agricultural.ui.view.IRegisterView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 注册页面
 */
public class RegisterActivity extends MVPBaseActivity<IRegisterView, RegisterPresenter> implements IRegisterView {

    @Bind(R.id.et_name)
    EditText mEtName;
    @Bind(R.id.et_mobile)
    EditText mEtMobile;
    @Bind(R.id.et_code)
    EditText mEtCode;
    @Bind(R.id.et_pwd)
    EditText mEtPwd;
    @Bind(R.id.et_repwd)
    EditText mEtRePwd;
    @Bind(R.id.tv_name_error_prompt)
    TextView mTvNamePrompt;
    @Bind(R.id.tv_mobile_error_prompt)
    TextView mTvMobilePrompt;
    @Bind(R.id.tv_code_error_prompt)
    TextView mTvCodePrompt;
    @Bind(R.id.tv_pwd_error_prompt)
    TextView mTvPwdPrompt;
    @Bind(R.id.tv_repwd_error_prompt)
    TextView mTvRepwdPrompt;
    @Bind(R.id.iv_name)
    ImageView mIvName;
    @Bind(R.id.iv_mobile)
    ImageView mIvMobile;
    @Bind(R.id.iv_code)
    ImageView mIvCode;
    @Bind(R.id.iv_pwd)
    ImageView mIvPwd;
    @Bind(R.id.iv_repwd)
    ImageView mIvRepwd;
    @Bind(R.id.btn_next_step)
    Button mBtnCommit;

    private RegisterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        this.mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("注册信息");

        initEvent();
    }

    private void initEvent() {
        mEtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mPresenter.existsMobile(mEtName.getText().toString().trim());
                }
            }
        });

        mEtMobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mPresenter.validateMobile(mEtMobile.getText().toString().trim());
                }
            }
        });

        mEtPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mPresenter.validatePwd(mEtPwd.getText().toString().trim());
                }
            }
        });

        mEtRePwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mPresenter.validateRePwd(mEtPwd.getText().toString().trim(), mEtRePwd.getText().toString().trim());
                }
            }
        });

        mBtnCommit.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {

        switch (view.getId()){
            case R.id.btn_next_step:
                register();
                break;
        }
    }

    private void register() {

        String name = mEtName.getText().toString().trim();
        String mobile = mEtMobile.getText().toString().trim();
        String code = mEtCode.getText().toString().trim();
        String pwd = mEtPwd.getText().toString().trim();
        String repwd = mEtRePwd.getText().toString().trim();

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(mobile) || TextUtils.isEmpty(pwd)){

        }else{
            if(pwd.equals(repwd)){
                mPresenter.register(name, mobile, code, pwd);
            }
        }
    }

    @Override
    public void setExistsMobileResult(BaseEntity data) {
        if (!data.isSuccess()) {
            mTvNamePrompt.setText(getResources().getText(R.string.register_name_error_prompt));
        } else {
            mIvName.setImageResource(R.drawable.img_check_mark);
            mTvNamePrompt.setText("");
        }
    }

    @Override
    public void setValidateResult(boolean b) {
        if (b) {
            mIvMobile.setImageResource(R.drawable.img_check_mark);
            mTvMobilePrompt.setText("");
        } else {
            mTvMobilePrompt.setText(getResources().getText(R.string.register_mobile_num_error_prompt));
        }
    }

    @Override
    public void setValidatePwdResult(boolean b) {
        if (b) {
            mIvPwd.setImageResource(R.drawable.img_check_mark);
            mTvPwdPrompt.setText("");
        } else {
            mTvPwdPrompt.setText(getResources().getText(R.string.register_pwd_error_prompt));
        }
    }

    @Override
    public void setValidateRePwdResult(boolean b) {
        if (b) {
            mIvRepwd.setImageResource(R.drawable.img_check_mark);
            mTvRepwdPrompt.setText("");
        } else {
            mTvRepwdPrompt.setText(getResources().getText(R.string.register_repwd_error_prompt));
        }
    }

    @Override
    public void registerSuccess(BaseEntity data) {
        if(data.isSuccess()){
            ShowToast.Short(data.getMessage());
            back();
        }
    }
}
