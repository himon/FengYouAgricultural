package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.ShoppingCartEvent;
import com.louis.agricultural.presenter.ShoppingCartFragmentPresenter;
import com.louis.agricultural.ui.activity.me.ConfirmOrderActivity;
import com.louis.agricultural.ui.adapter.ShoppingCartAdapter;
import com.louis.agricultural.ui.view.IShoppingCartView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.view.GetMoreListView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * 购物车
 */
public class ShoppingCartFragment extends MVPBaseFragment<IShoppingCartView, ShoppingCartFragmentPresenter> implements IShoppingCartView, View.OnClickListener {

    @Bind(R.id.iv_nav_left)
    ImageView mNavLeft;
    @Bind(R.id.tv_nav_right)
    TextView mTvNavRight;
    @Bind(R.id.tv_nav_title)
    TextView mNavTitle;
    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;
    @Bind(R.id.cb_all_check)
    CheckBox mCbAll;
    @Bind(R.id.tv_total_price)
    TextView mTvTotalPrice;
    @Bind(R.id.btn_calc)
    Button mBtnCalc;

    //是否是下拉刷新
    private boolean isRefresh;
    private ShoppingCartAdapter mAdapter;
    private List<ShoppingCartEntity.ResultEntity> mList = new ArrayList<>();

    private ShoppingCartFragmentPresenter mPresenter;
    private UserEntity mUser;

    public ShoppingCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        mPresenter = mMPresenter;
        initView();
        initData();
        return view;
    }

    @Override
    protected ShoppingCartFragmentPresenter createPresenter() {
        return new ShoppingCartFragmentPresenter(this);
    }

    protected void initTitle(String title) {
        mNavTitle.setText(title);
        mTvNavRight.setText("编辑");
        mTvNavRight.setVisibility(View.VISIBLE);
        mNavLeft.setVisibility(View.GONE);
    }

    public void refresh() {
        getData();
    }

    @Override
    protected void initView() {

        initTitle("购物车");

        mUser = FYApplication.getContext().getUserEntity();

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

        initEvent();
    }

    private void initEvent() {
        mTvNavRight.setOnClickListener(this);
        mBtnCalc.setOnClickListener(this);
        mCbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (ShoppingCartEntity.ResultEntity item : mList) {
                    item.setCheck(isChecked);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void getData() {
        mUser = FYApplication.getContext().getUserEntity();
        if (mUser != null) {
            mPresenter.get_goodscart(mUser.getResult().get_id());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_nav_right:
                break;
            case R.id.btn_calc:
                toConfirmOrder();
                break;

        }
    }

    private void toConfirmOrder() {

        ArrayList<ShoppingCartEntity.ResultEntity> list = new ArrayList<>();
        for (ShoppingCartEntity.ResultEntity item : mList) {
            if (item.isCheck()) {
                list.add(item);
            }
        }

        if (list.size() == 0) {
            ShowToast.Short("请选择要结算的商品!");
            return;
        }

        Intent intent = new Intent(getActivity(), ConfirmOrderActivity.class);
        intent.putParcelableArrayListExtra(Constants.MESSAGE_EXTRA_KEY, list);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, mTvTotalPrice.getText().toString().trim());
        startActivity(intent);
    }


    @Override
    public void setShoppingCart(ShoppingCartEntity data) {
        mList = data.getResult();

        mListView.setNoMore();
        mAdapter.setmDatas(mList);
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();

        mBtnCalc.setText("去结算（" + mList.size() + "）");

        BigDecimal total = new BigDecimal(0.00);

        for (ShoppingCartEntity.ResultEntity entity : mList) {
            total = total.add(entity.getSell_price());
        }
        mTvTotalPrice.setText("合计：￥" + total.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }

    public void onEvent(ShoppingCartEvent event) {
        if ("refresh".equals(event.getMsg())) {
            refresh();
        } else if ("check".equals(event.getMsg())) {
            check();
        }
    }

    private void check() {
        int count = 0;
        for (ShoppingCartEntity.ResultEntity item : mList) {
            if (item.isCheck()) {
                count++;
            }
        }

        if (mList.size() == count) {
            mCbAll.setChecked(true);
        } else {
            mCbAll.setChecked(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
