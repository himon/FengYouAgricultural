package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.constants.Constants;
import com.louis.agricultural.ui.fragment.message.AnnouncementFragment;
import com.louis.agricultural.ui.fragment.message.DistributionFragment;
import com.louis.agricultural.ui.fragment.message.NewsFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageActivity extends BaseActivity {

    @Bind(R.id.vp_viewpager)
    ViewPager mViewPager;

    private ArrayList<Fragment> mTabs = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    private AnnouncementFragment mAnnouncementFragment;
    private NewsFragment mNewsFragment;
    private DistributionFragment mDistributionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mAnnouncementFragment = new AnnouncementFragment();
        mNewsFragment = new NewsFragment();
        mDistributionFragment = new DistributionFragment();

        mTabs.add(mAnnouncementFragment);
        mTabs.add(mNewsFragment);
        mTabs.add(mDistributionFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };

    }

    @Override
    protected void initData() {
        int index = 0;
        Intent intent = getIntent();
        if (intent != null) {
            index = intent.getIntExtra(Constants.MESSAGE_EXTRA_KEY, 0);
        }
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(index);
    }

    @Override
    protected void click(View view) {

    }
}
