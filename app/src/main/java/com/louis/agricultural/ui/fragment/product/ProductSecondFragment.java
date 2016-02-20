package com.louis.agricultural.ui.fragment.product;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.ui.adapter.ProductSecondAdapter;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSecondFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.tab_left)
    TextView mTvLeft;
    @Bind(R.id.tab_mid)
    TextView mTvMid;
    @Bind(R.id.tab_right)
    TextView mTvRight;
    @Bind(R.id.indicator)
    UnderlinePageIndicator mIndicator;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private ProductSecondAdapter mAdapter;

    public ProductSecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_second, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }


    @Override
    protected void initView() {

        List<String> urls = new ArrayList<>();
        urls.add("http://www.qq.com");
        urls.add("http://www.taobao.com");
        urls.add("https://www.baidu.com");

        mAdapter = new ProductSecondAdapter(getActivity().getSupportFragmentManager());
        mAdapter.setUrls(urls);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mIndicator.setViewPager(mViewPager);
        mIndicator.setFades(false);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                clearTextColor();
                switch (position) {
                    case 0:
                        mTvLeft.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                        break;
                    case 1:
                        mTvMid.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                        break;
                    case 2:
                        mTvRight.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
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
        mTvLeft.setOnClickListener(this);
        mTvMid.setOnClickListener(this);
        mTvRight.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_left:
                mViewPager.setCurrentItem(0);
                clearTextColor();
                mTvLeft.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                break;
            case R.id.tab_mid:
                mViewPager.setCurrentItem(1);
                clearTextColor();
                mTvMid.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                break;
            case R.id.tab_right:
                mViewPager.setCurrentItem(2);
                clearTextColor();
                mTvRight.setTextColor(getResources().getColor(R.color.home_tab_red_bg));
                break;
        }
    }

    private void clearTextColor() {
        mTvLeft.setTextColor(getResources().getColor(R.color.main_search_font_gray));
        mTvMid.setTextColor(getResources().getColor(R.color.main_search_font_gray));
        mTvRight.setTextColor(getResources().getColor(R.color.main_search_font_gray));
    }
}
