package com.louis.agricultural.ui.fragment.message;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.entities.DistributionEntity;
import com.louis.agricultural.ui.adapter.DistributionAdapter;
import com.louis.agricultural.view.GetMoreListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 配送
 */
public class DistributionFragment extends BaseFragment {

    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;

    //是否是下拉刷新
    private boolean isRefresh;
    private DistributionAdapter mAdapter;
    private List<DistributionEntity> mList = new ArrayList<>();

    public DistributionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_distribution, container, false);
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

        mAdapter = new DistributionAdapter(getActivity(), mList, R.layout.adapter_distribution);
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
            DistributionEntity entity = new DistributionEntity();
            entity.setContent("#2016年3月4日，有五吨化肥需要从河南洛阳运送到上海浦东新区#");
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
