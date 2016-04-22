package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.ClassifyEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.presenter.ClassifyFragmentPresenter;
import com.louis.agricultural.ui.activity.ProductDetailsActivity;
import com.louis.agricultural.ui.activity.SearchActivity;
import com.louis.agricultural.ui.adapter.ClassifyAdapter;
import com.louis.agricultural.ui.adapter.ClassifyProductAdapter;
import com.louis.agricultural.ui.view.IClassifyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 分类
 */
public class ClassifyFragment extends MVPBaseFragment<IClassifyView, ClassifyFragmentPresenter> implements IClassifyView, View.OnClickListener {

    @Bind(R.id.listview)
    ListView mListView;
    @Bind(R.id.gridview)
    GridView mGridView;
    @Bind(R.id.et_search)
    EditText mEtSearch;
    @Bind(R.id.iv_search)
    ImageView mIvSearch;

    private ClassifyFragmentPresenter mPresenter;

    private ClassifyAdapter mClassifyAdapter;
    private ClassifyProductAdapter mClassifyProductAdapter;
    private List<ClassifyEntity.ResultEntity> mClassifyList = new ArrayList<>();
    private List<ProductEntity.ResultEntity> mProductList = new ArrayList<>();


    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        ButterKnife.bind(this, view);
        mPresenter = mMPresenter;
        initView();
        initData();
        return view;
    }

    @Override
    protected ClassifyFragmentPresenter createPresenter() {
        return new ClassifyFragmentPresenter(this);
    }

    @Override
    protected void initView() {
        mClassifyAdapter = new ClassifyAdapter(getActivity(), mClassifyList, R.layout.adapter_classify);
        mListView.setAdapter(mClassifyAdapter);

        mClassifyProductAdapter = new ClassifyProductAdapter(getActivity(), mProductList, R.layout.adapter_classify_product);
        mGridView.setAdapter(mClassifyProductAdapter);
        initEvent();
    }

    private void initEvent() {

        mIvSearch.setOnClickListener(this);

        mEtSearch.setOnKeyListener(new View.OnKeyListener() {//输入完后按键盘上的搜索键【回车键改为了搜索键】

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && KeyEvent.ACTION_DOWN == event.getAction()) {
                    //修改回车键功能
                    // 先隐藏键盘
                    ((InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getActivity()
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    //跳转到搜索结果界面
                    toSearchResult(mEtSearch.getText().toString().trim());
                }
                return false;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassifyEntity.ResultEntity entity = (ClassifyEntity.ResultEntity) parent.getAdapter().getItem(position);
                for (ClassifyEntity.ResultEntity item : mClassifyList) {
                    if (item.getId().equals(entity.getId())) {
                        item.setChecked(true);
                    } else {
                        item.setChecked(false);
                    }
                }
                mClassifyAdapter.notifyDataSetChanged();
                mPresenter.getSearchGoods(entity.getId(), "", "id");
            }
        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductEntity.ResultEntity entity = (ProductEntity.ResultEntity) parent.getAdapter().getItem(position);
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra(Constants.MESSAGE_EXTRA_KEY, entity.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getCategory("0");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                toSearchResult(mEtSearch.getText().toString().trim());
                break;
        }
    }

    private void toSearchResult(String search) {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, search);
        startActivity(intent);
    }


    @Override
    public void setClassify(ClassifyEntity data) {
        mClassifyList = data.getResult();
        mClassifyList.get(0).setChecked(true);
        mClassifyAdapter.setmDatas(mClassifyList);
        mClassifyAdapter.notifyDataSetChanged();

        mPresenter.getSearchGoods(mClassifyList.get(0).getId(), "", "id");
    }

    @Override
    public void setProducts(ProductEntity data) {
        mProductList = data.getResult();
        mClassifyProductAdapter.setmDatas(mProductList);
        mClassifyProductAdapter.notifyDataSetChanged();
    }
}
