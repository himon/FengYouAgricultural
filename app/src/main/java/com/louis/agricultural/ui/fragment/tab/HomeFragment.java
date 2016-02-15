package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.louis.agricultural.R;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.constants.Constants;
import com.louis.agricultural.ui.activity.MessageActivity;
import com.louis.agricultural.ui.activity.ProductDetailsActivity;
import com.louis.agricultural.ui.activity.account.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.rl_recommend1)
    RelativeLayout mRlRecommend1;
    @Bind(R.id.ll_brand)
    LinearLayout mLLBrand;
    @Bind(R.id.ll_announcement)
    LinearLayout mLLAnnouncement;
    @Bind(R.id.ll_news)
    LinearLayout mLLNews;
    @Bind(R.id.ll_distribution)
    LinearLayout mLLDistribution;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();

        return view;
    }

    @Override
    protected void initView() {
        initEvent();
    }

    private void initEvent() {
        mRlRecommend1.setOnClickListener(this);
        mLLBrand.setOnClickListener(this);
        mLLAnnouncement.setOnClickListener(this);
        mLLNews.setOnClickListener(this);
        mLLDistribution.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_recommend1:
                toGoodsDetail();
                break;
            case R.id.ll_brand:
                toLogin();
                break;
            case R.id.ll_announcement:
                toMessage(0);
                break;
            case R.id.ll_news:
                toMessage(1);
                break;
            case R.id.ll_distribution:
                toMessage(2);
                break;
        }
    }

    private void toMessage(int index) {
        Intent intent = new Intent(getActivity(), MessageActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, index);
        startActivity(intent);
    }

    private void toLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    private void toGoodsDetail() {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        startActivity(intent);
    }
}
