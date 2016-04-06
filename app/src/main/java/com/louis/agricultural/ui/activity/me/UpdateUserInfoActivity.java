package com.louis.agricultural.ui.activity.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.presenter.UpdateUserInfoActivityPresenter;
import com.louis.agricultural.ui.view.IUpdateUserInfoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UpdateUserInfoActivity extends MVPBaseActivity<IUpdateUserInfoView, UpdateUserInfoActivityPresenter> implements IUpdateUserInfoView {

    @Bind(R.id.et_content)
    EditText mEtContent;

    private UpdateUserInfoActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected UpdateUserInfoActivityPresenter createPresenter() {
        return new UpdateUserInfoActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("编辑");
        mTvNavRight.setText("保存");
        mTvNavRight.setVisibility(View.VISIBLE);

        initEvent();
    }

    private void initEvent() {
        mTvNavRight.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {
        switch (view.getId()){
            case R.id.tv_nav_right:
                mPresenter.userUpuserinformation(mEtContent.getText().toString());
                break;
        }
    }
}
