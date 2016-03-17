package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.ui.adapter.TabAdapter;
import com.louis.agricultural.ui.fragment.MyOrderFragment;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的订单
 */
public class MyOrderActivity extends BaseActivity {

    @Bind(R.id.indicator)
    UnderlinePageIndicator mIndicator;
    @Bind(R.id.id_viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tv_all)
    TextView mTvAll;
    @Bind(R.id.tv_pay)
    TextView mTvPay;
    @Bind(R.id.tv_get)
    TextView mTvGet;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    @Bind(R.id.tv_finish)
    TextView mTvFinish;

    private TabAdapter mTabAdapter;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mPageTitle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

        initTitle("我的订单");

        MyOrderFragment fragment1 = new MyOrderFragment();
        MyOrderFragment fragment2 = new MyOrderFragment();
        MyOrderFragment fragment3 = new MyOrderFragment();
        MyOrderFragment fragment4 = new MyOrderFragment();
        MyOrderFragment fragment5 = new MyOrderFragment();

        Bundle bundle1 = new Bundle();
        bundle1.putString(Constants.MESSAGE_EXTRA_KEY, "0");
        fragment1.setArguments(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants.MESSAGE_EXTRA_KEY, "0");
        fragment2.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putString(Constants.MESSAGE_EXTRA_KEY, "0");
        fragment3.setArguments(bundle3);

        Bundle bundle4 = new Bundle();
        bundle4.putString(Constants.MESSAGE_EXTRA_KEY, "0");
        fragment4.setArguments(bundle4);

        Bundle bundle5 = new Bundle();
        bundle5.putString(Constants.MESSAGE_EXTRA_KEY, "0");
        fragment5.setArguments(bundle5);

        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);
        mFragments.add(fragment4);
        mFragments.add(fragment5);

        mPageTitle.add("全部");
        mPageTitle.add("待付款");
        mPageTitle.add("待收货");
        mPageTitle.add("待评价");
        mPageTitle.add("交易完成");

        mTabAdapter = new TabAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mTabAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mIndicator.setViewPager(mViewPager);
        mIndicator.setFades(false);

        initEvent();
    }

    private void initEvent() {
        mTvAll.setOnClickListener(this);
        mTvPay.setOnClickListener(this);
        mTvCommit.setOnClickListener(this);
        mTvGet.setOnClickListener(this);
        mTvFinish.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.tv_all:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.tv_pay:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.tv_get:
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.tv_commit:
                mViewPager.setCurrentItem(3, false);
                break;
            case R.id.tv_finish:
                mViewPager.setCurrentItem(4, false);
                break;
        }
    }
}
