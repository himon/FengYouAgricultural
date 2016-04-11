package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.OrderDetailEntity;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.event.MyOrderEvent;
import com.louis.agricultural.presenter.OrderDetailActivityPresenter;
import com.louis.agricultural.ui.view.IOrderDetailView;
import com.louis.agricultural.utils.ShowToast;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 订单详情
 */
public class OrderDetailActivity extends MVPBaseActivity<IOrderDetailView, OrderDetailActivityPresenter> implements IOrderDetailView {

    @Bind(R.id.tv_order_no)
    TextView mTvOrderNo;
    @Bind(R.id.tv_order_status)
    TextView mTvOrderStatus;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_mobile)
    TextView mTvMobile;
    @Bind(R.id.tv_address)
    TextView mTvAddress;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_desc)
    TextView mTvDesc;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.tv_num)
    TextView mTvNum;
    @Bind(R.id.tv_call)
    TextView mTvCall;
    @Bind(R.id.tv_fee)
    TextView mTvFee;
    @Bind(R.id.tv_total_price)
    TextView mTvTotalPrice;
    @Bind(R.id.tv_create_time)
    TextView mTvCreateTime;
    @Bind(R.id.btn_left)
    Button mBtnLeft;
    @Bind(R.id.btn_right)
    Button mBtnRight;
    @Bind(R.id.iv_pic)
    ImageView mIvPic;

    private OrderEntity.ResultEntity mOrder;
    private OrderDetailActivityPresenter mPresenter;
    private OrderDetailEntity.ResultBean orderEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected OrderDetailActivityPresenter createPresenter() {
        return new OrderDetailActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("订单详情");
        initEvent();
    }

    private void initEvent() {
        mBtnLeft.setOnClickListener(this);
        mBtnRight.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mOrder = intent.getParcelableExtra(Constants.MESSAGE_EXTRA_KEY);
        }

        mPresenter.getOrderShow(mOrder.getId());
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                if ("2".equals(orderEntity.getOrder_status()) && "1".equals(orderEntity.getPayment_status())) {
                    //EventBus.getDefault().post(new MyOrderEvent("pay"));
//                    MyOrderEvent event = new MyOrderEvent("update_pay");
//                    event.setOrderId(orderEntity.getId());
//                    event.setStatus("2");
//                    EventBus.getDefault().post(event);

                    mPresenter.updateOrder(mOrder.getId(), "payment_status", "2");
                } else if ("2".equals(orderEntity.getOrder_status()) && "2".equals(orderEntity.getPayment_status())) {

                } else if ("3".equals(orderEntity.getOrder_status())) {
//                    MyOrderEvent event = new MyOrderEvent("update");
//                    event.setOrderId(orderEntity.getId());
//                    event.setStatus("5");
//                    EventBus.getDefault().post(event);

                    mPresenter.updateOrder(mOrder.getId(), "status", "5");
                }
                break;
            case R.id.btn_right:
                if ("2".equals(orderEntity.getOrder_status()) && "1".equals(orderEntity.getPayment_status())) {
//                    MyOrderEvent event = new MyOrderEvent("update");
//                    event.setOrderId(orderEntity.getId());
//                    event.setStatus("4");
//                    EventBus.getDefault().post(event);

                    mPresenter.updateOrder(mOrder.getId(), "status", "4");
                } else if ("2".equals(orderEntity.getOrder_status()) && "2".equals(orderEntity.getPayment_status())) {
//                    MyOrderEvent event = new MyOrderEvent("update");
//                    event.setOrderId(orderEntity.getId());
//                    event.setStatus("3");
//                    EventBus.getDefault().post(event);

                    mPresenter.updateOrder(mOrder.getId(), "status", "3");
                } else if ("3".equals(orderEntity.getOrder_status())) {
//                    MyOrderEvent event = new MyOrderEvent("comment");
//                    event.setOrderId(orderEntity.getOrder_id());
//                    event.setOrderGoodsId(orderEntity.getId());

                    Intent intent = new Intent(this, CommentActivity.class);
                    intent.putExtra(Constants.MESSAGE_EXTRA_KEY, orderEntity.getId());
                    intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, orderEntity.getArticle_id());
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void setData(OrderDetailEntity data) {

        orderEntity = data.getResult().get(0);

        mTvOrderNo.setText("订单号 " + mOrder.getOrder_no());
        mTvAddress.setText(mOrder.getArea() + mOrder.getAddress());
        mTvMobile.setText(mOrder.getTelphone());
        mTvName.setText(mOrder.getUser_name());
        mTvNum.setText(mOrder.getRow_number());
        mTvTitle.setText(orderEntity.getGoods_title());
        mTvPrice.setText(orderEntity.getGoods_price());
        mTvFee.setText(mOrder.getPayment_fee());
        mTvTotalPrice.setText(orderEntity.getGoods_price());

        if ("2".equals(orderEntity.getOrder_status()) && "1".equals(orderEntity.getPayment_status())) {
            mTvOrderStatus.setText("待付款");
            mTvOrderStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.button_yellow_bg));
            mBtnRight.setText("取消订单");
            mBtnLeft.setText("前去付款");
            mBtnLeft.setVisibility(View.VISIBLE);
        } else if ("2".equals(orderEntity.getOrder_status()) && "2".equals(orderEntity.getPayment_status())) {
            mTvOrderStatus.setText("已发货");
            mTvOrderStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.login_btn_bg));
            mBtnRight.setText("确认收货");
            mBtnLeft.setVisibility(View.GONE);
        } else if ("3".equals(orderEntity.getOrder_status())) {
            mTvOrderStatus.setText("交易成功");
            mTvOrderStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.login_btn_bg));
            mBtnRight.setText("评价");
            mBtnLeft.setText("删除订单");
            mBtnLeft.setVisibility(View.VISIBLE);
        }

        Glide.with(this)
                .load(orderEntity.getImg_url())
                .centerCrop()
                .crossFade()
                .into(mIvPic);
    }

    @Override
    public void setUpdateOrderSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
    }
}
