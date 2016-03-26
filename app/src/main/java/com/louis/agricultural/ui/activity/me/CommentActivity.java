package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.UserEntity;

/**
 * 发表评论Activity
 */
public class CommentActivity extends BaseActivity {

    private String mOrderId;
    private UserEntity.ResultEntity mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {

        mUser = FYApplication.getContext().getUserEntity().getResult();
        Intent intent = getIntent();
        if(intent != null){
            mOrderId = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
        }
    }

    @Override
    protected void click(View view) {

    }
}
