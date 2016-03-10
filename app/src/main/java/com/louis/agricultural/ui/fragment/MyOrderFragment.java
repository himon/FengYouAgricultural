package com.louis.agricultural.ui.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.presenter.MyOrderFragmentPresenter;
import com.louis.agricultural.ui.adapter.MyOrderAdapter;
import com.louis.agricultural.ui.view.IMyOrderView;
import com.louis.agricultural.view.GetMoreListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderFragment extends MVPBaseFragment<IMyOrderView, MyOrderFragmentPresenter> implements IMyOrderView {

    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;

    private MyOrderFragmentPresenter mPresenter;

    //是否是下拉刷新
    private boolean isRefresh;
    private int page = 1;

    private MyOrderAdapter mAdapter;
    private List<OrderEntity.ResultEntity> mList = new ArrayList<>();
    private String status;
    private UserEntity.ResultEntity mUser;

    public MyOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
        ButterKnife.bind(this, view);
        mPresenter = mMPresenter;
        initView();
        initData();
        return view;
    }

    @Override
    protected MyOrderFragmentPresenter createPresenter() {
        return new MyOrderFragmentPresenter(this);
    }


    @Override
    protected void initView() {

        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getString(Constants.MESSAGE_EXTRA_KEY);
        }
        mUser = FYApplication.getContext().getUserEntity().getResult();


        mListView.setOnGetMoreListener(new GetMoreListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                isRefresh = false;
                getData();
            }
        });

        mAdapter = new MyOrderAdapter(getActivity(), mList, R.layout.adapter_my_order);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrderEntity.ResultEntity entity = (OrderEntity.ResultEntity) parent.getAdapter().getItem(position);
                toDetail(entity);
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
        mPresenter.getOrderList(mUser.get_id(), page, status);
    }

    private void toDetail(OrderEntity.ResultEntity entity) {

    }

    @Override
    public void setData(OrderEntity data) {
        mList = data.getResult();
        mListView.setNoMore();
        mAdapter.setmDatas(mList);
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();
    }
}
