package com.louis.agricultural.ui.activity.me;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.utils.FileSizeUtil;
import com.louis.agricultural.utils.ShowToast;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class SettingActivity extends BaseActivity {

    @Bind(R.id.btn_logout)
    Button mBtnLogout;
    @Bind(R.id.ll_clear)
    LinearLayout mLLClear;
    @Bind(R.id.tv_size)
    TextView mTvSize;

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
        mLLClear.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        double fileOrFilesSize = FileSizeUtil.getFileOrFilesSize(getCacheDir().getAbsolutePath(), 3);
        mTvSize.setText(fileOrFilesSize + "m");
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_logout:
                EventBus.getDefault().post(new LoginResultEvent("logout"));
                FYApplication.getContext().setUserEntity(null);
                ShowToast.Short("退出登录!");
                back();
                break;
            case R.id.ll_clear:
                clearCache();
                break;
        }
    }

    /**
     * 清除缓存
     */
    public void clearCache() {
        ImageLoader.getInstance().clearMemoryCache();
        ImageLoader.getInstance().clearDiskCache();
        ///data/data/com.chunsun.redenvelope/cache
        File cacheDir = getCacheDir();
        if (cacheDir.exists()) {
            deleteChunsunFile(cacheDir);
        }

        ShowToast.Short("清除缓存成功");
        double fileOrFilesSize = FileSizeUtil.getFileOrFilesSize(getCacheDir().getAbsolutePath(), 3);
        mTvSize.setText(fileOrFilesSize + "m");
    }

    /**
     * 删除sd卡文件
     *
     * @param oldPath
     */
    private void deleteChunsunFile(File oldPath) {
        if (oldPath.isDirectory()) {
            File[] files = oldPath.listFiles();
            for (File file : files) {
                deleteChunsunFile(file);
                file.delete();
            }
        } else if (oldPath.isFile()) {
            oldPath.delete();
        }
    }
}
