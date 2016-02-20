package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
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

        MyOrderFragment fragment1 = new MyOrderFragment();
        MyOrderFragment fragment2 = new MyOrderFragment();
        MyOrderFragment fragment3 = new MyOrderFragment();
        MyOrderFragment fragment4 = new MyOrderFragment();
        MyOrderFragment fragment5 = new MyOrderFragment();
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
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {

    }
}
