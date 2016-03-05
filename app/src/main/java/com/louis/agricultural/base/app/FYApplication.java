package com.louis.agricultural.base.app;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.louis.agricultural.BuildConfig;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.utils.StrictModeUtil;
import com.louis.agricultural.utils.logger.LogLevel;
import com.louis.agricultural.utils.logger.Logger;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/1/23 9:42
 * @des
 */
public class FYApplication extends Application {

    private static FYApplication mContext;

    private UserEntity mUserEntity;

    private RefWatcher refWatcher;

    public static FYApplication getContext() {
        return mContext;
    }

    public UserEntity getUserEntity() {
        return mUserEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        mUserEntity = userEntity;
    }

    public static RefWatcher getRefWatcher(Context context) {
        FYApplication application = (FYApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        StrictModeUtil.init();
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        mContext = this;
        ImageLoadProxy.initImageLoader(this);

        if (BuildConfig.DEBUG) {
            Logger.init().hideThreadInfo().setMethodCount(1).setLogLevel(LogLevel.FULL);
        }

        Stetho.initializeWithDefaults(this);

//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
    }


}
