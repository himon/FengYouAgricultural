package com.louis.agricultural.base.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.utils.ActivityManager;
import com.louis.agricultural.utils.ShowToast;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2015/12/18 16:45
 * @des 处理用户登录无效的Presenter类
 */
public abstract class UserLosePresenter<T> extends BasePresenter<T> {

    /**
     * 未登录请求错误
     *
     * @param msg     服务器返回消息
     * @param context 上下文
     * @param from    登录成功后跳转到哪
     */
    public void onError(String msg, Context context, String from) {
        ShowToast.Short(msg);
        Intent intent = new Intent(context, LoginActivity.class);
        if (!TextUtils.isEmpty(from)) {
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY, from);
        }
        context.startActivity(intent);
        ActivityManager.getAppManager().finishAllActivityExceptMain();
    }

    public void onError(String msg) {
        ShowToast.Short(msg);
    }

    public void onError(int event_tag, String msg) {

    }

    public void onException(String msg) {
        ShowToast.Short(msg);
    }

}
