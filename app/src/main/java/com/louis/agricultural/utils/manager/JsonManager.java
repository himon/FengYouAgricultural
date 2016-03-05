package com.louis.agricultural.utils.manager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lc on 16/2/29.
 */
public class JsonManager {

    /**
     * 获取首页轮播图
     *
     * @param top
     * @return
     */
    public static String getIndexImage(String top) {
        JSONObject object = new JSONObject();
        try {
            object.put("top", top);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 验证账号是否注册
     *
     * @param username
     * @return
     */
    public static String existsMobile(String username) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", username);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 登陆
     *
     * @param user_name
     * @param user_pass
     * @return
     */
    public static String login(String user_name, String user_pass) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_name", user_name);
            object.put("user_pass", user_pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @param usertjr
     * @return
     */
    public static String register(String username, String password, String usertjr) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", username);
            object.put("password", password);
            object.put("usertjr", usertjr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 修改密码
     *
     * @param
     * @param user_id
     * @param user_pass
     * @return
     */
    public static String userUpdatePass(String user_id, String user_pass, String new_pass) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("user_pass", user_pass);
            object.put("new_pass", new_pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 获取个人信息
     *
     * @param user_id
     * @return
     */
    public static String getUserInfomation(String user_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 上传头像
     *
     * @param user_id
     * @param images
     * @return
     */
    public static String uploadImg(String user_id, String images) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("images", images);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }
}
