package com.louis.agricultural.base.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/7/16.
 */
public class Preferences {

    private static SharedPreferences mySetting;

    public Preferences(Context context) {

        if (mySetting == null) {
            if (context != null) {
                mySetting = context.getSharedPreferences("louis", Context.MODE_PRIVATE);
            }
        }
    }

    /**
     * 保存token信息
     *
     * @param token
     */
    public void setToken(String token) {
        mySetting.edit().putString("token", token).commit();
    }

    /**
     * 获取信鸽token的信息
     *
     * @return
     */
    public String getXGToken() {
        return mySetting.getString("xg_token", "");
    }

    /**
     * 保存信鸽token信息
     *
     * @param token
     */
    public void setXGToken(String token) {
        mySetting.edit().putString("xg_token", token).commit();
    }

    /**
     * 获取token的信息
     *
     * @return
     */
    public String getToken() {
        return mySetting.getString("token", "");
    }

    /**
     * 支付宝提现，支付宝账号
     *
     * @param data
     */
    public void setAlipayAcount(String data) {
        mySetting.edit().putString("alipay_acount", data).commit();
    }

    public String getAlipayAccount() {
        return mySetting.getString("alipay_acount", "");
    }

    /**
     * 支付宝提现，支付宝姓名
     *
     * @param data
     */
    public void setAlipayName(String data) {
        mySetting.edit().putString("alipay_name", data).commit();
    }

    public String getAlipayName() {
        return mySetting.getString("alipay_name", "");
    }
}
