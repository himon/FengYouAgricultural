package com.louis.agricultural.ui.fragment.product;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.model.entities.ProductDetailEntity;
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

        Bundle bundle = getArguments();
        String id = bundle.getString(Constants.MESSAGE_EXTRA_KEY);

        List<String> urls = new ArrayList<>();
        urls.add(Constants.GOODS_DETAIL_URL + id);

        mAdapter = new ProductSecondAdapter(getActivity().getSupportFragmentManager());
        mAdapter.setUrls(urls);

        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initEvent();
    }

    private void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
