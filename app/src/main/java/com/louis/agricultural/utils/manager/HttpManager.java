package com.louis.agricultural.utils.manager;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.AnnouncementEntity;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ClassifyEntity;
import com.louis.agricultural.model.entities.DistributionEntity;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.model.entities.FyttEntity;
import com.louis.agricultural.model.entities.HomeAdImageEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.net.GsonRequest;
import com.louis.agricultural.net.RequestManager;
import com.louis.agricultural.ui.activity.ProductDetailsActivity;
import com.louis.agricultural.utils.StringUtil;

import java.util.ArrayList;
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
        GsonRequest<ProductEntity> request = new GsonRequest<ProductEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ProductEntity.class, null, new Response.Listener<ProductEntity>() {

            @Override
            public void onResponse(ProductEntity response) {
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

        GsonRequest<ProductEntity> request = new GsonRequest<ProductEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ProductEntity.class, null, new Response.Listener<ProductEntity>() {

            @Override
            public void onResponse(ProductEntity response) {
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
    public void register(final String username, final String mobile, final String usertjr, final String password, final UserLoseMultiLoadedListener listener, Activity activity) {
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
                byte[] data = error.networkResponse.data;
                String str = new String(data);
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.USER_REGISTER);
                params.put("parames", JsonManager.register(username, mobile, password, usertjr));
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

    /**
     * 丰友商品分类
     *
     * @param category_parentid
     * @param listener
     * @param fragment
     */
    public void getCategory(final String category_parentid, final UserLoseMultiLoadedListener listener, Fragment fragment) {

        GsonRequest<ClassifyEntity> request = new GsonRequest<ClassifyEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ClassifyEntity.class, null, new Response.Listener<ClassifyEntity>() {

            @Override
            public void onResponse(ClassifyEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_CATEGORY_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //byte[] data = error.networkResponse.data;
                //String str = new String(data);
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_CATEGORY);
                params.put("parames", JsonManager.getCategory(category_parentid));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 根据类别和搜索查询商品
     *
     * @param category_id
     * @param search
     * @param paixu
     * @param listener
     * @param fragment
     * @param activity
     */
    public void getSearchGoods(final String category_id, final String search, final String paixu, final UserLoseMultiLoadedListener listener, Fragment fragment, Activity activity) {
        GsonRequest<ProductEntity> request = new GsonRequest<ProductEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ProductEntity.class, null, new Response.Listener<ProductEntity>() {

            @Override
            public void onResponse(ProductEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_SEARCH_GOODS_LISTENER, response);
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
                params.put("methodName", Constants.GET_SEARCH_GOODS);
                params.put("parames", JsonManager.getSearchGoods(category_id, search, paixu));
                return params;
            }
        };
        if (fragment != null) {
            RequestManager.addRequest(request, fragment);
        } else {
            RequestManager.addRequest(request, activity);
        }
    }

    /**
     * 商品信息
     *
     * @param user_id
     * @param article_id
     * @param listener
     * @param activity
     */
    public void getGoodsShow(final String user_id, final String article_id, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<ProductDetailEntity> request = new GsonRequest<ProductDetailEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ProductDetailEntity.class, null, new Response.Listener<ProductDetailEntity>() {

            @Override
            public void onResponse(ProductDetailEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_GOODS_SHOW_LISTENER, response);
                } else {
                    listener.onError(response.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //byte[] data = error.networkResponse.data;
                //String str = new String(data);
                listener.onException(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("methodName", Constants.GET_GOODS_SHOW);
                params.put("parames", JsonManager.getGoodsShow(user_id, article_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 加入购物车
     *
     * @param user_id
     * @param goods_id
     * @param sum
     * @param listener
     * @param activity
     */
    public void getAddGoodscart(final String user_id, final String goods_id, final int sum, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_ADD_GOODSCART_LISTENER, response);
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
                params.put("methodName", Constants.GET_ADD_GOODSCART);
                params.put("parames", JsonManager.getAddGoodscart(user_id, goods_id, sum));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 查看购物车
     *
     * @param user_id
     * @param listener
     * @param fragment
     */
    public void getGoodsCart(final String user_id, final UserLoseMultiLoadedListener listener, Fragment fragment) {

        GsonRequest<ShoppingCartEntity> request = new GsonRequest<ShoppingCartEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ShoppingCartEntity.class, null, new Response.Listener<ShoppingCartEntity>() {

            @Override
            public void onResponse(ShoppingCartEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_GOODSCART_LISTENER, response);
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
                params.put("methodName", Constants.GET_GOODSCART);
                params.put("parames", JsonManager.getUserInfomation(user_id));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 添加收货地址
     *
     * @param user_id
     * @param sheng
     * @param shi
     * @param qu
     * @param xiangxi
     * @param code
     * @param shr
     * @param phone
     * @param status
     * @param listener
     * @param activity
     */
    public void getAddAddress(final String user_id, final String sheng, final String shi, final String qu, final String xiangxi, final String code, final String shr, final String phone, final String status, final UserLoseMultiLoadedListener listener, Activity activity) {

        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_ADD_ADRESS_LISTENER, response);
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
                params.put("methodName", Constants.GET_ADD_ADRESS);
                params.put("parames", JsonManager.getAddAddress(user_id, sheng, shi, qu, xiangxi, code, shr, phone, status));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 查看收货地址列表
     *
     * @param user_id
     * @param listener
     * @param activity
     */
    public void getAdress(final String user_id, final UserLoseMultiLoadedListener listener, Activity activity) {

        GsonRequest<ShoppingAddressEntity> request = new GsonRequest<ShoppingAddressEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ShoppingAddressEntity.class, null, new Response.Listener<ShoppingAddressEntity>() {

            @Override
            public void onResponse(ShoppingAddressEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_ADRESS_LISTENER, response);
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
                params.put("methodName", Constants.GET_ADRESS);
                params.put("parames", JsonManager.getUserInfomation(user_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 查看收货地址详情
     *
     * @param adress_id
     * @param listener
     * @param activity
     */
    public void getAdressShow(final String adress_id, final UserLoseMultiLoadedListener listener, Activity activity) {

        GsonRequest<ShoppingAddressEntity> request = new GsonRequest<ShoppingAddressEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ShoppingAddressEntity.class, null, new Response.Listener<ShoppingAddressEntity>() {

            @Override
            public void onResponse(ShoppingAddressEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_ADRESS_SHOW_LISTENER, response);
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
                params.put("methodName", Constants.GET_ADRESS_SHOW);
                params.put("parames", JsonManager.getAdressShow(adress_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 修改收货地址
     *
     * @param adress_id
     * @param user_id
     * @param sheng
     * @param shi
     * @param qu
     * @param xiangxi
     * @param code
     * @param shr
     * @param phone
     * @param status
     * @param listener
     * @param activity
     */
    public void updateAdress(final String adress_id, final String user_id, final String sheng, final String shi, final String qu, final String xiangxi, final String code, final String shr, final String phone, final String status, final UserLoseMultiLoadedListener listener, Activity activity) {

        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.UPDATE_ADRESS_LISTENER, response);
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
                params.put("methodName", Constants.UPDATE_ADRESS);
                params.put("parames", JsonManager.updateAdress(adress_id, user_id, sheng, shi, qu, xiangxi, code, shr, phone, status));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 查看公告 新闻和配送信息
     *
     * @param category_id
     * @param page
     * @param listener
     * @param fragment
     */
    public void getNewsListAnnouncement(final String category_id, final int page, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<AnnouncementEntity> request = new GsonRequest<AnnouncementEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                AnnouncementEntity.class, null, new Response.Listener<AnnouncementEntity>() {

            @Override
            public void onResponse(AnnouncementEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_NEWS_LIST_LISTENER, response);
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
                params.put("methodName", Constants.GET_NEWS_LIST);
                params.put("parames", JsonManager.getNewsList(category_id, page));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 添加商品订单
     *
     * @param user_id
     * @param adress_id
     * @param message
     * @param user_name
     * @param list
     * @param listener
     * @param activity
     */
    public void addOrder(final String user_id, final String adress_id, final String message, final String user_name, final ArrayList<ShoppingCartEntity.ResultEntity> list, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.ADD_ORDER_LISTENER, response);
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
                params.put("methodName", Constants.ADD_ORDER);
                params.put("parames", JsonManager.addOrder(user_id, adress_id, message, user_name, list));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 查看个人商品订单
     *
     * @param user_id
     * @param page
     * @param status
     * @param listener
     * @param fragment
     */
    public void getOrderList(final String user_id, final int page, final String status, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<OrderEntity> request = new GsonRequest<OrderEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                OrderEntity.class, null, new Response.Listener<OrderEntity>() {

            @Override
            public void onResponse(OrderEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_ORDER_LIST_LISTENER, response);
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
                params.put("methodName", Constants.GET_ORDER_LIST);
                params.put("parames", JsonManager.getOrderList(user_id, page, status));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 获取个人默认收货地址
     *
     * @param user_id
     * @param listener
     * @param activity
     */
    public void getDefaultAdress(final String user_id, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<ShoppingAddressEntity> request = new GsonRequest<ShoppingAddressEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                ShoppingAddressEntity.class, null, new Response.Listener<ShoppingAddressEntity>() {

            @Override
            public void onResponse(ShoppingAddressEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_DEFAULT_ADRESS_LISTENER, response);
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
                params.put("methodName", Constants.GET_DEFAULT_ADRESS);
                params.put("parames", JsonManager.getUserInfomation(user_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }

    /**
     * 查看配送信息
     *
     * @param category_id
     * @param page
     * @param listener
     * @param fragment
     */
    public void getNewsListDistribution(final String category_id, final int page, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<DistributionEntity> request = new GsonRequest<DistributionEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                DistributionEntity.class, null, new Response.Listener<DistributionEntity>() {

            @Override
            public void onResponse(DistributionEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.GET_NEWS_LIST_LISTENER, response);
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
                params.put("methodName", Constants.GET_NEWS_LIST);
                params.put("parames", JsonManager.getNewsList(category_id, page));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 删除购物车
     *
     * @param car_id
     * @param listener
     * @param fragment
     */
    public void deleteGoodscart(final String car_id, final UserLoseMultiLoadedListener listener, Fragment fragment) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.DELETE_GOODSCART_LISTENER, response);
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
                params.put("methodName", Constants.DELETE_GOODSCART);
                params.put("parames", JsonManager.deleteGoodscart(car_id));
                return params;
            }
        };
        RequestManager.addRequest(request, fragment);
    }

    /**
     * 删除收货地址
     *
     * @param adress_id
     * @param listener
     * @param activity
     */
    public void deleteAdress(final String adress_id, final UserLoseMultiLoadedListener listener, Activity activity) {
        GsonRequest<BaseEntity> request = new GsonRequest<BaseEntity>(Request.Method.POST, StringUtil.preUrl(Constants.WEB_SERVICE_URL),
                BaseEntity.class, null, new Response.Listener<BaseEntity>() {

            @Override
            public void onResponse(BaseEntity response) {
                if (response.isSuccess()) {
                    listener.onSuccess(Constants.DELETE_ADRESS_LISTENER, response);
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
                params.put("methodName", Constants.DELETE_ADRESS);
                params.put("parames", JsonManager.getAdressShow(adress_id));
                return params;
            }
        };
        RequestManager.addRequest(request, activity);
    }
}
