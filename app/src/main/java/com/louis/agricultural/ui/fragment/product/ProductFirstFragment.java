package com.louis.agricultural.ui.fragment.product;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louis.agricultural.R;
import com.louis.agricultural.base.fragment.BaseFragment;

/**
 * 商品详情的第一个Fragment
 */
public class ProductFirstFragment extends BaseFragment {


    public ProductFirstFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_first, container, false);
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
