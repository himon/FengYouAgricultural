package com.louis.agricultural.ui.activity.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.event.LoginResultEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class SettingActivity extends BaseActivity {

    @Bind(R.id.btn_logout)
    Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mBtnLogout.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {
        switch (view.getId()){
            case R.id.btn_logout:
                EventBus.getDefault().post(new LoginResultEvent("logout"));
                FYApplication.getContext().setUserEntity(null);
                back();
                break;
        }
    }
}
