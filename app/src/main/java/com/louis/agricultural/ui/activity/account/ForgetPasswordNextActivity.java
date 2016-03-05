package com.louis.agricultural.ui.activity.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.presenter.ForgetPasswordNextPresenter;
import com.louis.agricultural.ui.view.IForgetPasswordNextView;
import com.louis.agricultural.utils.ActivityManager;
import com.louis.agricultural.utils.ShowToast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 找回密码
 */
public class ForgetPasswordNextActivity extends MVPBaseActivity<IForgetPasswordNextView, ForgetPasswordNextPresenter> implements IForgetPasswordNextView {

    @Bind(R.id.et_old_pwd)
    EditText mEtOldPwd;
    @Bind(R.id.et_pwd)
    EditText mEtPwd;
    @Bind(R.id.et_repwd)
    EditText mEtRepwd;
    @Bind(R.id.iv_old_pwd)
    ImageView mIvOldPwd;
    @Bind(R.id.iv_pwd)
    ImageView mIvPwd;
    @Bind(R.id.iv_repwd)
    ImageView mIvRepwd;
    @Bind(R.id.tv_old_pwd_error_prompt)
    TextView mTvOldPwd;
    @Bind(R.id.tv_pwd_error_prompt)
    TextView mTvPwd;
    @Bind(R.id.tv_repwd_error_prompt)
    TextView mTvRepwd;
    @Bind(R.id.btn_update)
    Button mBtnUpdate;

    private ForgetPasswordNextPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_next);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected ForgetPasswordNextPresenter createPresenter() {
        return new ForgetPasswordNextPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("找回密码");

        mEtOldPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mPresenter.validateOldPwd(mEtOldPwd.getText().toString().trim());
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

        mEtRepwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mPresenter.validateRePwd(mEtPwd.getText().toString().trim(), mEtRepwd.getText().toString().trim());
                }
            }
        });

        mBtnUpdate.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                UserEntity.ResultEntity user = FYApplication.getContext().getUserEntity().getResult();
                String id = user.get_id();
                mPresenter.updatePwd(id, mEtOldPwd.getText().toString().trim(), mEtPwd.getText().toString().trim(), mEtRepwd.getText().toString().trim());
                break;
        }
    }

    @Override
    public void validatePwdResult(boolean b) {
        if (b) {
            mTvPwd.setText("");
            mIvPwd.setImageResource(R.drawable.img_check_mark);
        } else {
            mTvPwd.setText(getResources().getText(R.string.register_pwd_error_prompt));
            mIvPwd.setImageResource(R.drawable.img_no_check_mark);
        }
    }

    @Override
    public void validateRePwdResult(boolean b) {
        if (b) {
            mTvRepwd.setText("");
            mIvRepwd.setImageResource(R.drawable.img_check_mark);
        } else {
            mTvRepwd.setText(getResources().getText(R.string.register_repwd_error_prompt));
            mIvRepwd.setImageResource(R.drawable.img_no_check_mark);
        }
    }

    @Override
    public void validateOldPwdResult(boolean b) {
        if (b) {
            mTvOldPwd.setText("");
            mIvOldPwd.setImageResource(R.drawable.img_check_mark);
        } else {
            mTvOldPwd.setText(getResources().getText(R.string.register_pwd_error_prompt));
            mIvOldPwd.setImageResource(R.drawable.img_no_check_mark);
        }
    }

    @Override
    public void updateSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        ActivityManager.getAppManager().finishActivity(ForgetPasswordActivity.class);
        back();
    }
}
