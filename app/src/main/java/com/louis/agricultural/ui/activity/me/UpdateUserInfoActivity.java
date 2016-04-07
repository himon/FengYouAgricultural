package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.UpdateUserInfoEvent;
import com.louis.agricultural.presenter.UpdateUserInfoActivityPresenter;
import com.louis.agricultural.ui.view.IUpdateUserInfoView;
import com.louis.agricultural.utils.ShowToast;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class UpdateUserInfoActivity extends MVPBaseActivity<IUpdateUserInfoView, UpdateUserInfoActivityPresenter> implements IUpdateUserInfoView {

    @Bind(R.id.et_content)
    EditText mEtContent;
    @Bind(R.id.rg_sex)
    RadioGroup mRgSex;
    @Bind(R.id.rb_male)
    RadioButton mRbMale;
    @Bind(R.id.rb_female)
    RadioButton mRbFemale;
    @Bind(R.id.rb_secret)
    RadioButton mRbSecret;

    private UpdateUserInfoActivityPresenter mPresenter;
    private boolean mFlag;
    private UserEntity.ResultEntity mUser;
    private String mSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected UpdateUserInfoActivityPresenter createPresenter() {
        return new UpdateUserInfoActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("编辑");
        mTvNavRight.setText("保存");
        mTvNavRight.setVisibility(View.VISIBLE);
        initEvent();
    }

    private void initEvent() {
        mTvNavRight.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        mUser = FYApplication.getContext().getUserEntity().getResult();

        Intent intent = getIntent();
        if (intent != null) {
            mFlag = intent.getBooleanExtra(Constants.MESSAGE_EXTRA_KEY, true);
            if (mFlag) {
                mRgSex.setVisibility(View.GONE);
                String date = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY2);
                mEtContent.setText(date);
            } else {
                mEtContent.setVisibility(View.GONE);
                String date = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY2);
                if("男".equals(date)){
                    mRgSex.check(R.id.rb_male);
                }else if("女".equals(date)){
                    mRgSex.check(R.id.rb_female);
                }else{
                    mRgSex.check(R.id.rb_secret);
                }
            }
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.tv_nav_right:
                if (mFlag) {
                    mPresenter.userUpuserinformation(mUser.get_id(), mEtContent.getText().toString(), "nick_name");
                } else {
                    switch (mRgSex.getCheckedRadioButtonId()){
                        case R.id.rb_male:
                            mSex = "男";
                            break;
                        case R.id.rb_female:
                            mSex = "女";
                            break;
                        case R.id.rb_secret:
                            mSex = "保密";
                            break;
                    }
                    mPresenter.userUpuserinformation(mUser.get_id(), mSex, "sex");
                }
                break;
        }
    }

    @Override
    public void updateSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        if(mFlag){
            String name = mEtContent.getText().toString();
            mUser.set_nick_name(name);
            EventBus.getDefault().post(new UpdateUserInfoEvent(1, name));
        }else{
            mUser.set_sex(mSex);
            EventBus.getDefault().post(new UpdateUserInfoEvent(2, mSex));
        }
        back();
    }
}
