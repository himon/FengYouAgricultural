package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.ui.activity.me.CommentActivity;
import com.louis.agricultural.ui.activity.me.ConfirmOrderActivity;
import com.louis.agricultural.ui.activity.me.MyOrderActivity;
import com.louis.agricultural.ui.activity.me.SettingActivity;
import com.louis.agricultural.ui.activity.me.UserInfoActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.iwf.photopicker.utils.PhotoPickerIntent;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.tv_setting)
    TextView mTvSetting;
    @Bind(R.id.tv_username)
    TextView mTvUserName;
    @Bind(R.id.tv_user_info)
    TextView mTvUserInfo;
    @Bind(R.id.tv_see_order)
    TextView mTvOrder;
    @Bind(R.id.rl_obligations)
    RelativeLayout mRlObligations;//待付款
    @Bind(R.id.rl_comment)
    RelativeLayout mRlComment;

    public MeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);

        initEvent();
        return view;
    }

    private void initEvent() {
        mTvSetting.setOnClickListener(this);
        mTvUserInfo.setOnClickListener(this);
        mTvOrder.setOnClickListener(this);
        mRlObligations.setOnClickListener(this);
        mRlComment.setOnClickListener(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        UserEntity.ResultEntity user = FYApplication.getContext().getUserEntity().getResult();
        mTvUserName.setText(user.get_user_name());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_setting:
                toSetting();
                break;
            case R.id.tv_user_info:
                toUserInfo();
                break;
            case R.id.tv_see_order:
                toSeeOrder();
                break;
            case R.id.rl_obligations:
                toConfirmOrder();
                break;
            case R.id.rl_comment:
                toComment();
                break;
        }
    }

    private void toComment() {
        Intent intent = new Intent(getActivity(), CommentActivity.class);
        startActivity(intent);
    }

    private void toConfirmOrder() {
        Intent intent = new Intent(getActivity(), ConfirmOrderActivity.class);
        startActivity(intent);
    }

    private void toSeeOrder() {
        Intent intent = new Intent(getActivity(), MyOrderActivity.class);
        startActivity(intent);
    }

    private void toUserInfo() {
        Intent intent = new Intent(getActivity(), UserInfoActivity.class);
        startActivity(intent);
    }

    private void toSetting() {
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }
}
