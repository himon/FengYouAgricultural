package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.presenter.CommentActivityPresenter;
import com.louis.agricultural.ui.view.ICommentView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 发表评论Activity
 */
public class CommentActivity extends MVPBaseActivity<ICommentView, CommentActivityPresenter> implements ICommentView {

    @Bind(R.id.et_comment)
    EditText mEtComment;
    @Bind(R.id.btn_comment)
    Button mBtnComment;

    private String mGoodsId;
    private UserEntity.ResultEntity mUser;
    private CommentActivityPresenter mPresenter;
    private String mOrderGoodsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected CommentActivityPresenter createPresenter() {
        return new CommentActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("商品评论");

        initEvent();
    }

    private void initEvent() {
        mBtnComment.setOnClickListener(this);
    }


    @Override
    protected void initData() {

        mUser = FYApplication.getContext().getUserEntity().getResult();
        Intent intent = getIntent();
        if (intent != null) {
            mGoodsId = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
            mOrderGoodsId = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY2);
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_comment:
                mPresenter.comment(mGoodsId, mUser.get_id(), mUser.get_user_name(), mEtComment.getText().toString(), mOrderGoodsId);
                break;
        }
    }
}
