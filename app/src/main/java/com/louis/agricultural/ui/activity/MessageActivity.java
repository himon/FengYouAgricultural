package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.ui.fragment.message.AnnouncementFragment;
import com.louis.agricultural.ui.fragment.message.DistributionFragment;
import com.louis.agricultural.ui.fragment.message.NewsFragment;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageActivity extends BaseActivity {

    @Bind(R.id.tv_announcement)
    TextView mTvAnnouncement;
    @Bind(R.id.tv_news)
    TextView mTvNews;
    @Bind(R.id.tv_distribution)
    TextView mTvDistribution;
    @Bind(R.id.indicator)
    UnderlinePageIndicator mIndicator;
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

        initTitle("");

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

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                clearTextColor();
                switch (position) {
                    case 0:
                        mTvAnnouncement.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                        break;
                    case 1:
                        mTvNews.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                        break;
                    case 2:
                        mTvDistribution.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initEvent();
    }

    private void initEvent() {
        mTvAnnouncement.setOnClickListener(this);
        mTvNews.setOnClickListener(this);
        mTvDistribution.setOnClickListener(this);
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
        mIndicator.setViewPager(mViewPager);
        mIndicator.setFades(false);
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.tv_announcement:
                mViewPager.setCurrentItem(0);
                clearTextColor();
                mTvAnnouncement.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                break;
            case R.id.tv_news:
                mViewPager.setCurrentItem(1);
                clearTextColor();
                mTvNews.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                break;
            case R.id.tv_distribution:
                mViewPager.setCurrentItem(2);
                clearTextColor();
                mTvDistribution.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                break;
        }
    }

    private void clearTextColor() {
        mTvAnnouncement.setTextColor(getResources().getColor(R.color.main_search_font_gray));
        mTvNews.setTextColor(getResources().getColor(R.color.main_search_font_gray));
        mTvDistribution.setTextColor(getResources().getColor(R.color.main_search_font_gray));
    }
}
