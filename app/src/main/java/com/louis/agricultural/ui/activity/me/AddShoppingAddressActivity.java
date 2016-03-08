package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.ShoppingAddressEvent;
import com.louis.agricultural.presenter.AddShoppingAddressPresenter;
import com.louis.agricultural.ui.view.IAddShoppingAddressView;
import com.louis.agricultural.utils.ShowToast;

import butterknife.Bind;
import butterknife.ButterKnife;
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
    CheckBox mEbCheckBox;
    @Bind(R.id.btn_add_address)
    Button mBtnAdd;

    private AddShoppingAddressPresenter mPresenter;
    private UserEntity.ResultEntity mUser;

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
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mUser = FYApplication.getContext().getUserEntity().getResult();
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_add_address:
                boolean checked = mEbCheckBox.isChecked();
                String status = "0";
                if(checked){
                    status = "1";
                }
                mPresenter.getAddAddress(mUser.get_id(), "河南", "洛阳", "涧西", mEtAddress.getText().toString().trim(), mEtCode.getText().toString().trim(), mEtConsignee.getText().toString().trim(), mEtMobile.getText().toString().trim(), status);
                break;
        }
    }

    @Override
    public void addSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        EventBus.getDefault().post(new ShoppingAddressEvent("refresh"));
        back();
    }
}
