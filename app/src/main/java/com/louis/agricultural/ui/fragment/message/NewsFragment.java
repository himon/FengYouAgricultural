package com.louis.agricultural.ui.fragment.message;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.AnnouncementEntity;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.NewsEntity;
import com.louis.agricultural.presenter.AnnouncementFragmentPresenter;
import com.louis.agricultural.ui.activity.WebViewActivity;
import com.louis.agricultural.ui.adapter.NewsAdapter;
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
 * 新闻
 */
public class NewsFragment extends MVPBaseFragment<IAnnouncementView, AnnouncementFragmentPresenter> implements IAnnouncementView {

    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;

    //是否是下拉刷新
    private boolean isRefresh;
    private int page = 1;
    private NewsAdapter mAdapter;
    private List<AnnouncementEntity.ResultEntity> mList = new ArrayList<>();
    private AnnouncementFragmentPresenter mPresenter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
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

        mAdapter = new NewsAdapter(getActivity(), mList, R.layout.adapter_news);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AnnouncementEntity.ResultEntity entity = (AnnouncementEntity.ResultEntity) parent.getAdapter().getItem(position);
                toDetail(entity.getId());
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

    private void toDetail(String id) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, id);
        startActivity(intent);
    }

    @Override
    protected void initData() {

    }

    private void getData() {
        mPresenter.getNewsList("57", page);
    }

    private void setData() {
        mListView.setNoMore();
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();
    }

    @Override
    public void setData(BaseEntity data) {
        mList = ((AnnouncementEntity) data).getResult();
        mListView.setNoMore();
        mAdapter.setmDatas(mList);
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();
    }


}
