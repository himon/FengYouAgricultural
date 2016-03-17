package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.presenter.UpdatePasswordActivityPresenter;
import com.louis.agricultural.ui.view.IUpdatePasswordView;
import com.louis.agricultural.utils.ShowToast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 用户修改密码
 */
public class UpdatePasswordActivity extends MVPBaseActivity<IUpdatePasswordView, UpdatePasswordActivityPresenter> implements IUpdatePasswordView {

    @Bind(R.id.et_old_pwd)
    EditText mEtOldPwd;
    @Bind(R.id.et_pwd)
    EditText mEtPwd;
    @Bind(R.id.et_repwd)
    EditText mEtRepwd;
    @Bind(R.id.btn_commit)
    Button mBtnCommit;

    private UpdatePasswordActivityPresenter mPresenter;
    private UserEntity.ResultEntity mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected UpdatePasswordActivityPresenter createPresenter() {
        return new UpdatePasswordActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("修改密码");

        initEvent();
    }

    private void initEvent() {
        mBtnCommit.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mUser = FYApplication.getContext().getUserEntity().getResult();
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_commit:
                mPresenter.userUpdatePass(mUser.get_id(), mEtOldPwd.getText().toString().trim(), mEtPwd.getText().toString().trim(), mEtRepwd.getText().toString().trim());
                break;
        }
    }

    @Override
    public void updateSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        back();
    }
}
