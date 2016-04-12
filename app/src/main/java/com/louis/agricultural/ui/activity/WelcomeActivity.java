package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        initData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(0, 1500);
    }

    @Override
    protected void click(View view) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(0);
    }
}
