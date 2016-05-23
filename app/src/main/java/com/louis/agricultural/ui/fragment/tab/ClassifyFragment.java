package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.BankEntity;
import com.louis.agricultural.model.entities.ClassifyEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.presenter.ClassifyFragmentPresenter;
import com.louis.agricultural.ui.activity.GoodsDetailActivity;
import com.louis.agricultural.ui.activity.SearchActivity;
import com.louis.agricultural.ui.adapter.ClassifyAdapter;
import com.louis.agricultural.ui.adapter.ClassifyProductAdapter;
import com.louis.agricultural.ui.view.IClassifyView;
import com.louis.agricultural.utils.DensityUtils;
import com.louis.agricultural.utils.HeaderGridView;
import com.louis.agricultural.view.FlowLayout;

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
    HeaderGridView mGridView;
    @Bind(R.id.et_search)
    EditText mEtSearch;
    @Bind(R.id.iv_search)
    ImageView mIvSearch;

    //@Bind(R.id.id_flowlayout)
    FlowLayout mFlowLayout;
    FlowLayout mBankLayout;

    private ClassifyFragmentPresenter mPresenter;

    private ClassifyAdapter mClassifyAdapter;
    private ClassifyProductAdapter mClassifyProductAdapter;
    private List<ClassifyEntity.ResultEntity> mClassifyList = new ArrayList<>();
    private List<ProductEntity.ResultEntity> mProductList = new ArrayList<>();
    private LayoutInflater mInflater;
    private String mCId;


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

        LinearLayout linearLayout = new LinearLayout(getActivity());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        mFlowLayout = new FlowLayout(getActivity());
        mFlowLayout.setLayoutParams(params);
        mFlowLayout.setPadding(5, 5, 5, 5);
        mFlowLayout.setOnClickListener(this);

        mBankLayout = new FlowLayout(getActivity());
        mBankLayout.setLayoutParams(params);
        mBankLayout.setPadding(5, 5, 5, 5);
        mBankLayout.setOnClickListener(this);

        View view = new View(getActivity());
        ViewGroup.LayoutParams params2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.px2dip(getActivity(), 5));
        view.setLayoutParams(params2);
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.white));

        linearLayout.addView(mFlowLayout);
        linearLayout.addView(view);
        linearLayout.addView(mBankLayout);

        mGridView.addHeaderView(linearLayout);

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
                mPresenter.getCategory(entity.getId());
                mPresenter.getSearchGoods(entity.getId(), "0", "", "id");
                mPresenter.getGoodsbank(entity.getId());
                mCId = entity.getId();
            }
        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductEntity.ResultEntity entity = (ProductEntity.ResultEntity) parent.getAdapter().getItem(position);
                Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                intent.putExtra(Constants.MESSAGE_EXTRA_KEY, entity.getId());
                intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, entity.getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mInflater = LayoutInflater.from(getActivity());
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
        ClassifyEntity.ResultEntity entity = mClassifyList.get(0);
        entity.setChecked(true);
        mClassifyAdapter.setmDatas(mClassifyList);
        mClassifyAdapter.notifyDataSetChanged();

        mPresenter.getSearchGoods(mClassifyList.get(0).getId(), "0", "", "id");
        mPresenter.getGoodsbank(mClassifyList.get(0).getId());
        mPresenter.getCategory(entity.getId());
        mCId = entity.getId();
    }

    @Override
    public void setProducts(ProductEntity data) {
        mProductList = data.getResult();
        mClassifyProductAdapter.setmDatas(mProductList);
        mClassifyProductAdapter.notifyDataSetChanged();
    }

    @Override
    public void setSecondClassify(ClassifyEntity data) {
        final List<ClassifyEntity.ResultEntity> result = data.getResult();
        mFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final ClassifyEntity.ResultEntity entity = result.get(i);
            TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                    mFlowLayout, false);
            tv.setText(entity.getTitle());
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getSearchGoods(entity.getId(), "0", "", "id");
                    mCId = entity.getId();
                    System.out.print("CID: " + mCId);
                    clearFlowLayout();
                    clearBankLayout();
                    TextView tv = (TextView) v;
                    tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.font_red));
                }
            });
            mFlowLayout.addView(tv);
        }
    }

    private void clearFlowLayout() {
        int childCount = mFlowLayout.getChildCount();
        for(int i = 0; i < childCount; i++){
            TextView childAt = (TextView) mFlowLayout.getChildAt(i);
            childAt.setTextColor(ContextCompat.getColor(getActivity(), R.color.font_text_classify));
        }
    }

    @Override
    public void setGoodsBank(BankEntity data) {
        List<BankEntity.ResultBean> result = data.getResult();
        mBankLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final BankEntity.ResultBean entity = result.get(i);
            TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                    mBankLayout, false);
            tv.setText(entity.getBankname());
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.print("CID: " + mCId);
                    mPresenter.getSearchGoods(mCId, entity.getBankid(), "", "id");
                    clearBankLayout();
                    TextView tv = (TextView) v;
                    tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.font_red));
                }
            });
            mBankLayout.addView(tv);
        }
    }

    private void clearBankLayout() {
        int childCount = mBankLayout.getChildCount();
        for(int i = 0; i < childCount; i++){
            TextView childAt = (TextView) mBankLayout.getChildAt(i);
            childAt.setTextColor(ContextCompat.getColor(getActivity(), R.color.font_text_classify));
        }
    }
}
