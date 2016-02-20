package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.ui.activity.SearchActivity;
import com.louis.agricultural.ui.adapter.ClassifyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.listview)
    ListView mListView;
    @Bind(R.id.gridview)
    GridView mGridView;
    @Bind(R.id.et_search)
    EditText mEtSearch;

    private List<String> classifyList = new ArrayList<>();
    private ClassifyAdapter mClassifyAdapter;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {
        mClassifyAdapter = new ClassifyAdapter(getActivity(), classifyList, R.layout.adapter_classify);
        mListView.setAdapter(mClassifyAdapter);

        initEvent();
    }

    private void initEvent() {

        mEtSearch.setOnKeyListener(new View.OnKeyListener() {//输入完后按键盘上的搜索键【回车键改为了搜索键】

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //修改回车键功能
                    // 先隐藏键盘
                    ((InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getActivity()
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    //跳转到搜索结果界面
                    toSearchResult();
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {
        getClassifyData();
    }

    private void getClassifyData() {
        for (int i = 0; i < 10; i++) {
            classifyList.add("热销产品");
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    private void toSearchResult() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
    }
}
