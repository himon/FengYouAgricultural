package com.louis.agricultural.utils.manager;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.entities.ShoppingCartEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

    /**
     * 丰友商品分类
     *
     * @param category_parentid
     * @return
     */
    public static String getCategory(String category_parentid) {
        JSONObject object = new JSONObject();
        try {
            object.put("category_parentid", category_parentid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 根据类别和搜索查询商品
     *
     * @param category_id
     * @param search
     * @param paixu
     * @return
     */
    public static String getSearchGoods(String category_id, String search, String paixu) {
        JSONObject object = new JSONObject();
        try {
            object.put("category_id", category_id);
            object.put("search", search);
            object.put("paixu", paixu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 商品信息
     *
     * @param article_id
     * @return
     */
    public static String getGoodsShow(String article_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("article_id", article_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 加入购物车
     *
     * @param user_id
     * @param goods_id
     * @param sum
     * @return
     */
    public static String getAddGoodscart(String user_id, String goods_id, int sum) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("goods_id", goods_id);
            object.put("sum", sum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
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
     * @return
     */
    public static String getAddAddress(String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("sheng", sheng);
            object.put("shi", shi);
            object.put("qu", qu);
            object.put("xiangxi", xiangxi);
            object.put("code", code);
            object.put("shr", shr);
            object.put("phone", phone);
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 查看收货地址详情
     *
     * @param adress_id
     * @return
     */
    public static String getAdressShow(String adress_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("adress_id", adress_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
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
     * @return
     */
    public static String updateAdress(String adress_id, String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status) {

        JSONObject object = new JSONObject();
        try {
            object.put("adress_id", adress_id);
            object.put("user_id", user_id);
            object.put("sheng", sheng);
            object.put("shi", shi);
            object.put("qu", qu);
            object.put("xiangxi", xiangxi);
            object.put("code", code);
            object.put("shr", shr);
            object.put("phone", phone);
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 查看公告 新闻和配送信息
     *
     * @param category_id
     * @param page
     * @return
     */
    public static String getNewsList(String category_id, int page) {
        JSONObject object = new JSONObject();
        try {
            object.put("category_id", category_id);
            object.put("pagesize", Constants.PAGESIZE);
            object.put("page", page);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 添加商品订单
     *
     * @param user_id
     * @param adress_id
     * @param message
     * @param user_name
     * @param list
     * @return
     */
    public static String addOrder(String user_id, String adress_id, String message, String user_name, ArrayList<ShoppingCartEntity.ResultEntity> list) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("adress_id", adress_id);
            object.put("message", message);
            object.put("user_name", user_name);

            JSONArray goods = new JSONArray();
            for (ShoppingCartEntity.ResultEntity item : list) {
                JSONObject good = new JSONObject();
                good.put("sum", item.getSum());
                good.put("goods_id", item.getGoods_id());
                good.put("goods_price", item.getSell_price());
                good.put("real_price", item.getSell_price());
                good.put("spec_text", "");
                good.put("goods_no", item.getGoods_no());
                goods.put(good);
            }
            object.put("goods", goods);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();

    }

    /**
     * 查看个人商品订单
     *
     * @param user_id
     * @param page
     * @param status
     * @return
     */
    public static String getOrderList(String user_id, int page, String status) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("pagesize", Constants.PAGESIZE);
            object.put("page", page);
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }
}
