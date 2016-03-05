package com.louis.agricultural.utils.manager;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.FytjEntity;
import com.louis.agricultural.model.entities.FyttEntity;
import com.louis.agricultural.model.entities.HomeAdImageEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.net.GsonRequest;
import com.louis.agricultural.net.RequestManager;
import com.louis.agricultural.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lc on 16/2/29.
 */
public class HttpManager {

    /**
     * 获取首页轮播图
     *
     * @param top
     * @param listener
     * @param fragment
     */
    public void getIndexImage(final int top, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<HomeAdImageEntity> request = new GsonRequest<HomeAdImageEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                HomeAdImageEntity.class, null, new Response.Listener<HomeAdImageEntity>() {

            @Override
            public void onResponse(HomeAdImageEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_INDEX_IMG_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_INDEX_IMG);
                params.put("parames", JsonManager.getIndexImage(top + ""));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);

    }

    /**
     * 首页丰友头条
     *
     * @param top
     * @param listener
     * @param fragment
     */
    public void getIndexFytt(final int top, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<FyttEntity> request = new GsonRequest<FyttEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                FyttEntity.class, null, new Response.Listener<FyttEntity>() {

            @Override
            public void onResponse(FyttEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_INDEX_FYTT_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_INDEX_FYTT);
                params.put("parames", JsonManager.getIndexImage(top + ""));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 首页精品推荐
     *
     * @param top
     * @param listener
     * @param fragment
     */
    public void getIndexFytj(final int top, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<FytjEntity> request = new GsonRequest<FytjEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                FytjEntity.class, null, new Response.Listener<FytjEntity>() {

            @Override
            public void onResponse(FytjEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_INDEX_JPTJ_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_INDEX_JPTJ);
                params.put("parames", JsonManager.getIndexImage(top + ""));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 首页热门推荐
     *
     * @param top
     * @param listener
     * @param fragment
     */
    public void getIndexRmtj(final int top, final UserLoseMultiLoadedListener listener, Fragment fragment) {

        GsonRequest<FytjEntity> request = new GsonRequest<FytjEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                FytjEntity.class, null, new Response.Listener<FytjEntity>() {

            @Override
            public void onResponse(FytjEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_INDEX_RMTJ_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_INDEX_RMTJ);
                params.put("parames", JsonManager.getIndexImage(top + ""));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 验证账号是否注册
     *
     * @param username
     * @param listener
     * @param activity
     */
    public void existsMobile(final String username, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.EXISTS_MOBILE_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.EXISTS_MOBILE);
                params.put("parames", JsonManager.existsMobile(username));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 登陆
     *
     * @param user_name
     * @param user_pass
     * @param listener
     * @param activity
     */
    public void login(final String user_name, final String user_pass, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<UserEntity> request = new GsonRequest<UserEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                UserEntity.class, null, new Response.Listener<UserEntity>() {

            @Override
            public void onResponse(UserEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.USER_LOGIN_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.USER_LOGIN);
                params.put("parames", JsonManager.login(user_name, user_pass));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 注册
     *
     * @param username
     * @param mobile
     * @param usertjr
     * @param password
     * @param listener
     * @param activity
     */
    public void register(final String username, String mobile, final String usertjr, final String password, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.USER_REGISTER_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.USER_REGISTER);
                params.put("parames", JsonManager.register(username, password, usertjr));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 修改密码
     *
     * @param user_id
     * @param user_pass
     * @param listener
     * @param activity
     */
    public void userUpdatePass(final String user_id, final String user_pass, final String new_pass, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.USER_UPDATEPASS_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.USER_UPDATEPASS);
                params.put("parames", JsonManager.userUpdatePass(user_id, user_pass, new_pass));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 获取个人信息
     *
     * @param user_id
     * @param listener
     * @param activity
     */
    public void getUserInfomation(final String user_id, final UserLoseMultiLoadedListener listener, Activity activity) {

        GsonRequest<UserEntity> request = new GsonRequest<UserEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                UserEntity.class, null, new Response.Listener<UserEntity>() {

            @Override
            public void onResponse(UserEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_USER_INFOMATION_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_USER_INFOMATION);
                params.put("parames", JsonManager.getUserInfomation(user_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 获取头像
     *
     * @param user_id
     * @param listener
     * @param activity
     */
    public void getUserImg(final String user_id, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_USERIMG_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_USERIMG);
                params.put("parames", JsonManager.getUserInfomation(user_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    public void uploadImg(final String user_id, final String images, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.UPLOAD_IMG_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                byte[] data = error.networkResponse.data;
                String str = new String(data);
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.UPLOAD_IMG);
                params.put("parames", JsonManager.uploadImg(user_id, images));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }
}
