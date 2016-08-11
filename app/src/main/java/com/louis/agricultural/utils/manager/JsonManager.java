package com.louis.agricultural.utils.manager;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.entities.ShoppingCartEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
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
    public static String register(String username, String phone, String password, String usertjr) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", username);
            object.put("phone", phone);
            object.put("password", password);
            object.put("usertjr", usertjr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString().trim();
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
    public static String getSearchGoods(String category_id, String bankid, String search, String paixu) {
        JSONObject object = new JSONObject();
        try {
            object.put("category_id", category_id);
            object.put("bankid", bankid);
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
     * @param user_id
     * @param article_id
     * @return
     */
    public static String getGoodsShow(String user_id, String article_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("article_id", article_id);
            object.put("user_id", user_id);
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
    public static String getAddGoodscart(String user_id, String goods_id, String sum) {
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
            object.put("payment_id", "1");

            JSONArray goods = new JSONArray();
            for (ShoppingCartEntity.ResultEntity item : list) {
                JSONObject good = new JSONObject();

                String price = item.getSell_price().toString();
                String realPrice = item.getSell_price().multiply(new BigDecimal(item.getSum())).toString();

                good.put("sum", item.getSum());
                good.put("goods_id", item.getGoods_id());
                good.put("goods_price", price.substring(0, price.length() - 1));
                good.put("real_price", realPrice.substring(0, realPrice.length() - 1));
                good.put("spec_text", "规格描述");
                good.put("goods_no", item.getId());
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
     * @param
     * @param payment_status
     * @param status         @return
     */
    public static String getOrderList(String user_id, int page, String status, String payment_status, String express_status) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", user_id);
            object.put("pagesize", Constants.PAGESIZE);
            object.put("page", page);
            object.put("status", status);
            object.put("payment_status", payment_status);
            object.put("express_status", express_status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 删除购物车
     *
     * @param car_id
     * @return
     */
    public static String deleteGoodscart(String car_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("car_id", car_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 修改订单信息
     *
     * @param order_id
     * @param strxgname
     * @param strzhi
     * @return
     */
    public static String updateOrder(String order_id, String strxgname, String strzhi) {
        JSONObject object = new JSONObject();
        try {
            object.put("order_id", order_id);
            object.put("strxgname", strxgname);
            object.put("strzhi", strzhi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 修改用户信息
     *
     * @param user_name
     * @param strxgname
     * @param strzhi    @return
     */
    public static String userUpuserinformation(String user_name, String strxgname, String strzhi) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_name", user_name);
            object.put("strxgname", strxgname);
            object.put("strzhi", strzhi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * 添加评论
     *
     * @param goods_id
     * @param user_id
     * @param user_name
     * @param comment
     * @param order_goods_id
     * @return
     */
    public static String addGoodsComment(String goods_id, String user_id, String user_name, String comment, String order_goods_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("goods_id", goods_id);
            object.put("user_id", user_id);
            object.put("user_name", user_name);
            object.put("conment", comment);
            object.put("order_goods_id", order_goods_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    public static String getOrderShow(String order_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("order_id", order_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    public static String getGoodsbank(String paramString)
    {
        JSONObject localJSONObject = new JSONObject();
        try
        {
            localJSONObject.put("category_id", paramString);
            return localJSONObject.toString();
        }
        catch (JSONException localJSONException)
        {
            while (true)
                localJSONException.printStackTrace();
        }
    }

    public static String getGoodsbank12(String category_id) {
        JSONObject localJSONObject = new JSONObject();
        try
        {
            localJSONObject.put("category_id", category_id);
            return localJSONObject.toString();
        }
        catch (JSONException localJSONException)
        {
            while (true)
                localJSONException.printStackTrace();
        }
    }
}
