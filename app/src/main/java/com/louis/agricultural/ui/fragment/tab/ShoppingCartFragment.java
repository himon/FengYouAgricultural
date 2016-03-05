package com.louis.agricultural.ui.fragment.tab;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.ui.adapter.ShoppingCartAdapter;
import com.louis.agricultural.view.GetMoreListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 购物车
 */
public class ShoppingCartFragment extends BaseFragment {

    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;

    //是否是下拉刷新
    private boolean isRefresh;
    private ShoppingCartAdapter mAdapter;
    private List<ProductEntity> mList = new ArrayList<>();

    public ShoppingCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {
        mListView.setOnGetMoreListener(new GetMoreListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                isRefresh = false;
                getData();
            }
        });

        mAdapter = new ShoppingCartAdapter(getActivity(), mList, R.layout.adapter_shopping_cart);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mPtr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                isRefresh = true;
                getData();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtr.autoRefresh();
            }
        }, 100);
    }

    @Override
    protected void initData() {

    }

    private void getData() {
        for (int i = 0; i < 5; i++) {
            ProductEntity entity = new ProductEntity();
            entity.setTitle("鲁西 高塔尿基 40kg复合肥料 总养分 >45%");
            entity.setPrice("￥188.00");
            entity.setNum(1);
            mList.add(entity);
        }
        setData();
    }

    private void setData() {
        mListView.setNoMore();
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();
    }
}
