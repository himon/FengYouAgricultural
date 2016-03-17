package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.ShoppingAddressEvent;
import com.louis.agricultural.presenter.AddShoppingAddressPresenter;
import com.louis.agricultural.ui.activity.MainActivity;
import com.louis.agricultural.ui.view.IAddShoppingAddressView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.utils.helper.OptionsWindowHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.jeesoft.widget.pickerview.CharacterPickerWindow;
import de.greenrobot.event.EventBus;

/**
 * 添加地址
 */
public class AddShoppingAddressActivity extends MVPBaseActivity<IAddShoppingAddressView, AddShoppingAddressPresenter> implements IAddShoppingAddressView {

    @Bind(R.id.et_consignee)
    EditText mEtConsignee;
    @Bind(R.id.et_mobile)
    EditText mEtMobile;
    @Bind(R.id.ll_area)
    LinearLayout mLLArea;
    @Bind(R.id.tv_area)
    TextView mTvArea;
    @Bind(R.id.et_address)
    EditText mEtAddress;
    @Bind(R.id.et_code)
    EditText mEtCode;
    @Bind(R.id.eb_check)
    CheckBox mCbCheckBox;
    @Bind(R.id.btn_add_address)
    Button mBtnAdd;

    private AddShoppingAddressPresenter mPresenter;
    private UserEntity.ResultEntity mUser;
    private String mOper;
    private String mAddressId;
    private String mProvince;
    private String mCity;
    private String mArea;
    private CharacterPickerWindow mWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shipping_address);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected AddShoppingAddressPresenter createPresenter() {
        return new AddShoppingAddressPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("收货地址");
        initEvent();
    }

    private void initEvent() {
        mLLArea.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mOper = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
            if (!TextUtils.isEmpty(mOper)) {
                mAddressId = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY2);
                mPresenter.getAdressShow(mAddressId);
                mTvNavRight.setText("删除");
                mTvNavRight.setTextColor(ContextCompat.getColor(this, R.color.font_red));
                mTvNavRight.setVisibility(View.VISIBLE);
                mTvNavRight.setOnClickListener(this);
            }
        }
        mUser = FYApplication.getContext().getUserEntity().getResult();

        //初始化
        mWindow = OptionsWindowHelper.builder(this, new OptionsWindowHelper.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(String province, String city, String area) {
                mTvArea.setText(province + city + area);
                mProvince = province;
                mCity = city;
                mArea = area;
            }
        });

        mProvince = "河南";
        mCity = "洛阳";
        mArea = "西工区";
        mTvArea.setText(mProvince + mCity + mArea);
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_add_address:
                boolean checked = mCbCheckBox.isChecked();
                String status = "0";
                if (checked) {
                    status = "1";
                }
                if (TextUtils.isEmpty(mOper)) {
                    mPresenter.getAddAddress(mUser.get_id(), mProvince, mCity, mArea, mEtAddress.getText().toString().trim(), mEtCode.getText().toString().trim(), mEtConsignee.getText().toString().trim(), mEtMobile.getText().toString().trim(), status);
                } else {
                    mPresenter.updateAdress(mAddressId, mUser.get_id(), mProvince, mCity, mArea, mEtAddress.getText().toString().trim(), mEtCode.getText().toString().trim(), mEtConsignee.getText().toString().trim(), mEtMobile.getText().toString().trim(), status);
                }
                break;
            case R.id.tv_nav_right:
                mPresenter.deleteAdress(mAddressId);
                break;
            case R.id.ll_area:
                selectArea(view);
                break;
        }
    }

    private void selectArea(View v) {
        mWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void addSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        EventBus.getDefault().post(new ShoppingAddressEvent("refresh"));
        back();
    }

    @Override
    public void showAddress(ShoppingAddressEntity data) {
        ShoppingAddressEntity.ResultEntity address = data.getResult().get(0);
        mEtConsignee.setText(address.getShr());
        mEtMobile.setText(address.getPhone());
        mEtAddress.setText(address.getXiangxi());
        mEtConsignee.setText(address.getCode());
        mTvArea.setText(address.getSheng() + address.getShi() + address.getQu());
        if ("1".equals(address.getSheng())) {
            mCbCheckBox.setChecked(true);
        }
    }

    @Override
    public void updateSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        EventBus.getDefault().post(new ShoppingAddressEvent("refresh"));
        back();
    }

    @Override
    public void delSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        EventBus.getDefault().post(new ShoppingAddressEvent("refresh"));
        back();
    }
}
