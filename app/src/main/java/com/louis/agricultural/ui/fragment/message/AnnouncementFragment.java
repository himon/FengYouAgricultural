package com.louis.agricultural.ui.fragment.message;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.AnnouncementEntity;
import com.louis.agricultural.presenter.AnnouncementFragmentPresenter;
import com.louis.agricultural.ui.adapter.AnnouncementAdapter;
import com.louis.agricultural.ui.view.IAnnouncementView;
import com.louis.agricultural.view.GetMoreListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 公告
 */
public class AnnouncementFragment extends MVPBaseFragment<IAnnouncementView, AnnouncementFragmentPresenter> implements IAnnouncementView {

    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;

    private AnnouncementFragmentPresenter mPresenter;

    private int page = 1;
    //是否是下拉刷新
    private boolean isRefresh;
    private AnnouncementAdapter mAdapter;
    private List<AnnouncementEntity> mList = new ArrayList<>();

    public AnnouncementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        ButterKnife.bind(this, view);
        mPresenter = mMPresenter;
        initView();
        initData();
        return view;
    }

    @Override
    protected AnnouncementFragmentPresenter createPresenter() {
        return new AnnouncementFragmentPresenter(this);
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

        mAdapter = new AnnouncementAdapter(getActivity(), mList, R.layout.adapter_announcement);
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
//        for (int i = 0; i < 5; i++) {
//            AnnouncementEntity entity = new AnnouncementEntity();
//            entity.setContent("#促销# 红日阿康有机肥料10元 /5斤满减包邮！！活动时间：2016年1月15——18日。快来抢购！！！！");
//            entity.setTime("今天");
//            mList.add(entity);
//        }

        mPresenter.getNewsList("56", page);
    }

    private void setData() {
        mListView.setNoMore();
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();
    }
}
