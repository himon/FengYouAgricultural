package com.louis.agricultural.ui.fragment.tab;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import com.louis.agricultural.ui.fragment.MyOrderFragment;
import com.louis.agricultural.view.CircleTransform;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.iwf.photopicker.utils.PhotoPickerIntent;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.tv_setting)
    TextView mTvSetting;
    @Bind(R.id.iv_head_icon)
    ImageView mIvHeadIcon;
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
    @Bind(R.id.rl_wait_get)
    RelativeLayout mRlWaitGet;
    @Bind(R.id.ll_call)
    LinearLayout mLLCall;

    public MeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);

        initView();
        initData();
        return view;
    }

    public void refresh() {
        initData();
    }

    private void initEvent() {
        mTvSetting.setOnClickListener(this);
        mTvUserInfo.setOnClickListener(this);
        mTvOrder.setOnClickListener(this);
        mRlObligations.setOnClickListener(this);
        mRlComment.setOnClickListener(this);
        mRlWaitGet.setOnClickListener(this);
        mLLCall.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        initEvent();
    }

    @Override
    protected void initData() {
        UserEntity user = FYApplication.getContext().getUserEntity();
        if (user != null) {
            mTvUserName.setText(user.getResult().get_user_name());
            Glide.with(this).load(user.getResult().get_avatar()).transform(new CircleTransform(getActivity())).into(mIvHeadIcon);
        }
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
            case R.id.rl_wait_get:
                toWaitGet();
                break;
            case R.id.ll_call:
                testCall();
                break;
        }
    }

    private void toWaitGet() {
        Intent intent = new Intent(getActivity(), MyOrderActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, 2);
        startActivity(intent);
    }

    private void toComment() {
        Intent intent = new Intent(getActivity(), MyOrderActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, 3);
        startActivity(intent);
    }

    private void toConfirmOrder() {
        Intent intent = new Intent(getActivity(), MyOrderActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, 1);
        startActivity(intent);
    }

    private void toSeeOrder() {
        Intent intent = new Intent(getActivity(), MyOrderActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, 0);
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

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public void testCall()
    {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else
        {
            callPhone();
        }
    }

    public void callPhone()
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "03796232551");
        intent.setData(data);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {

        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhone();
            } else
            {
                // Permission Denied
                Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
