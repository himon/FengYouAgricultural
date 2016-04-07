package com.louis.agricultural.ui.activity.me;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ResultStringEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.UpdateUserInfoEvent;
import com.louis.agricultural.presenter.UserInfoActivityPresenter;
import com.louis.agricultural.ui.view.IUserInfoView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.view.CircleTransform;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.utils.PhotoPickerIntent;

/**
 * 个人中心
 */
public class UserInfoActivity extends MVPBaseActivity<IUserInfoView, UserInfoActivityPresenter> implements IUserInfoView {

    @Bind(R.id.ll_head_icon)
    LinearLayout mLLHead;
    @Bind(R.id.iv_head_icon)
    ImageView mIvHead;
    @Bind(R.id.ll_update_pwd)
    LinearLayout mLLUpdatePwd;
    @Bind(R.id.ll_nick_name)
    LinearLayout mLLNickName;
    @Bind(R.id.tv_nick_name)
    TextView mTvNickName;
    @Bind(R.id.ll_sex)
    LinearLayout mLLSex;
    @Bind(R.id.tv_sex)
    TextView mTvSex;
    @Bind(R.id.ll_shipping_address)
    LinearLayout mLLShippingAddress;
    @Bind(R.id.ll_date)
    LinearLayout mLLDate;
    @Bind(R.id.tv_date)
    TextView mTvDate;

    private UserInfoActivityPresenter mPresenter;
    private UserEntity.ResultEntity mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected UserInfoActivityPresenter createPresenter() {
        return new UserInfoActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("个人中心");
        initEvent();
    }

    private void initEvent() {
        mLLHead.setOnClickListener(this);
        mLLUpdatePwd.setOnClickListener(this);
        mLLShippingAddress.setOnClickListener(this);
        mLLDate.setOnClickListener(this);
        mLLSex.setOnClickListener(this);
        mLLNickName.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mUser = FYApplication.getContext().getUserEntity().getResult();
        Glide.with(this).load(mUser.get_avatar()).transform(new CircleTransform(this)).into(mIvHead);
        mPresenter.getUserInfomation(mUser.get_id());

        mTvNickName.setText(mUser.get_nick_name());
        mTvSex.setText(mUser.get_sex());
        if (mUser.get_birthday() != null) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
//            String date = format.format(mUser.get_birthday());
//            mTvDate.setText(date);
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.ll_update_pwd:
                toUpdatePwd();
                break;
            case R.id.ll_shipping_address:
                toShippingAddress();
                break;
            case R.id.ll_head_icon:
                selectHeadImage();
                break;
            case R.id.ll_date:
                selectDate();
                break;
            case R.id.ll_nick_name:
                toUpdateUserInfo(true);
                break;
            case R.id.ll_sex:
                toUpdateUserInfo(false);
                break;
        }
    }

    private void toUpdateUserInfo(boolean b) {
        Intent intent = new Intent(this, UpdateUserInfoActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, b);
        if (b) {
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, mUser.get_nick_name());
        } else {
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, mUser.get_sex());
        }
        startActivity(intent);
    }

    private void selectDate() {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mTvDate.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");

                mPresenter.userUpuserinformation(mUser.get_id(), year + "-" + ((monthOfYear + 1) < 10 ? "0" + (monthOfYear + 1) : (monthOfYear + 1)) + "-" + (dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth), "birthday");
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void toShippingAddress() {
        Intent intent = new Intent(this, ShoppingAddressActivity.class);
        startActivity(intent);
    }

    private void toUpdatePwd() {
        Intent intent = new Intent(this, UpdatePasswordActivity.class);
        startActivity(intent);
    }

    /**
     * 设置头像
     */
    private void selectHeadImage() {
        PhotoPickerIntent intent = new PhotoPickerIntent(this);
        intent.setPhotoCount(1);
        intent.setShowCamera(true);
        startActivityForResult(intent, Constants.REQUEST_CODE);
    }

    /**
     * 跳转到剪切图片Activity
     *
     * @param path
     */
    private void toImageCutActivity(String path) {
        Intent intent = new Intent(this, PicClipActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, path);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, false);
        startActivityForResult(intent, Constants.REQUEST_CODE_IMAGE_CUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == Constants.REQUEST_CODE) {
            if (data != null) {
                List<Photo> photos = data.getParcelableArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
                toImageCutActivity(photos.get(0).getPath());
            }
        } else if (requestCode == Constants.REQUEST_CODE_IMAGE_CUT) {
            if (data != null) {
                mPresenter.uploadImg(mUser.get_id(), data);
            }
        }
    }

    @Override
    public void updateSuccess(BaseEntity data, String type) {
        ShowToast.Short(data.getMessage());
        if ("img".equals(type)) {
            mPresenter.getUserImg(mUser.get_id());
        } else {
        }
    }

    @Override
    public void setUserImg(BaseEntity data) {
        ResultStringEntity entity = (ResultStringEntity) data;
        Glide.with(this).load(entity.getResult()).transform(new CircleTransform(this)).into(mIvHead);
        UserEntity.ResultEntity result = FYApplication.getContext().getUserEntity().getResult();
        result.set_avatar(((ResultStringEntity) data).getResult());
        EventBus.getDefault().post(new LoginResultEvent("refresh_head_icon"));
    }

    public void onEvent(UpdateUserInfoEvent event) {
        if (event.getType() == 1) {
            mTvNickName.setText(event.getMsg());
        } else if (event.getType() == 2) {
            mTvSex.setText(event.getMsg());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
