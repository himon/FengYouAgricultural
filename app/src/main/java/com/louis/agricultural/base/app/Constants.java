package com.louis.agricultural.base.app;

/**
 * Created by lc on 16/2/29.
 */
public interface Constants {

    String HOST_URL = "http://115.28.134.18:8087";


    /** 后台接口 **/
    /**
     * 正式发布时需要修正-----web service地址
     */
    String NEW_URL = HOST_URL + "/MethodIn.asmx/";
    /**
     * web service地址接口
     */
    String WEB_SERVICE_URL = NEW_URL + "CaseMethad";
    /**
     * 用户登录
     */
    String USER_LOGIN = "user_login";
    /**
     * 验证账号是否注册
     */
    String EXISTS_MOBILE = "exists_mobile";
    /**
     * 修改密码
     */
    String USER_UPDATEPASS = "user_updatepass";
    /**
     * 修改个人资料
     */
    String USER_UPUSERINFOMATION = "user_upuserinformation";
    /**
     * 获取个人信息
     */
    String GET_USER_INFOMATION = "get_user_information";
    /**
     * 获取头像
     */
    String GET_USERIMG = "get_userimg";
    /**
     * 上传头像
     */
    String UPLOAD_IMG = "upload_img";
    /**
     * 用户注册
     */
    String USER_REGISTER = "user_register";
    /**
     * 首页轮播图
     */
    String GET_INDEX_IMG = "get_index_img";
    /**
     * 丰友头条
     */
    String GET_INDEX_FYTT = "get_index_fytt";
    /**
     * 丰友首页精品推荐
     */
    String GET_INDEX_JPTJ = "get_index_jptj";
    /**
     * 丰友首页热门推荐
     */
    String GET_INDEX_RMTJ = "get_index_rmtj";
    /**
     * 丰友商品信息
     */
    String GET_GOODS_SHOW = "get_goods_show";
    /**
     * 丰友商品分类
     */
    String GET_CATEGORY = "get_category";
    /**
     * 丰友商品分类
     */
    String GET_SEARCH_GOODS = "get_search_goods";
    /**
     * 加入购物车
     */
    String GET_ADD_GOODSCART = "get_add_goodscart";
    /**
     * 查看购物车
     */
    String GET_GOODSCART = "get_goodscart";
    /**
     * 删除购物车
     */
    String DELETE_GOODSCART = "delete_goodscart";
    /**
     * 添加收货地址
     */
    String GET_ADD_ADRESS = "get_add_adress";
    /**
     * 查看收货地址列表
     */
    String GET_ADRESS = "get_adress";
    /**
     * 查看收货地址详情
     */
    String GET_ADRESS_SHOW = "get_adress_show";
    /**
     * 删除收货地址
     */
    String DELETE_ADRESS = "delete_adress";
    /**
     * 查看个人商品订单
     */
    String GET_ORDER_LIST = "get_order_list";
    /**
     * 查看订单详情
     */
    String GET_ORDER_SHOW = "get_order_show";
    /**
     * 添加商品订单
     */
    String ADD_ORDER = "add_order";


    /** 获取数据成功回调的key **/
    /**
     * 用户登录
     */
    int USER_LOGIN_LISTENER = 0x10001;
    /**
     * 验证账号是否注册
     */
    int EXISTS_MOBILE_LISTENER = 0x10002;
    /**
     * 修改密码
     */
    int USER_UPDATEPASS_LISTENER = 0x10003;
    /**
     * 修改个人资料
     */
    int USER_UPUSERINFOMATION_LISTENER = 0x10004;
    /**
     * 获取个人信息
     */
    int GET_USER_INFOMATION_LISTENER = 0x10005;
    /**
     * 获取头像
     */
    int GET_USERIMG_LISTENER = 0x10006;
    /**
     * 上传头像
     */
    int UPLOAD_IMG_LISTENER = 0x10007;
    /**
     * 用户注册
     */
    int USER_REGISTER_LISTENER = 0x10008;
    /**
     * 首页轮播图
     */
    int GET_INDEX_IMG_LISTENER = 0x10009;
    /**
     * 丰友头条
     */
    int GET_INDEX_FYTT_LISTENER = 0x10010;
    /**
     * 丰友首页精品推荐
     */
    int GET_INDEX_JPTJ_LISTENER = 0x10011;
    /**
     * 丰友首页热门推荐
     */
    int GET_INDEX_RMTJ_LISTENER = 0x10012;
    /**
     * 丰友商品信息
     */
    int GET_GOODS_SHOW_LISTENER = 0x10013;
    /**
     * 丰友商品分类
     */
    int GET_CATEGORY_LISTENER = 0x10014;
    /**
     * 丰友商品分类
     */
    int GET_SEARCH_GOODS_LISTENER = 0x10015;
    /**
     * 加入购物车
     */
    int GET_ADD_GOODSCART_LISTENER = 0x10016;
    /**
     * 查看购物车
     */
    int GET_GOODSCART_LISTENER = 0x10017;
    /**
     * 删除购物车
     */
    int DELETE_GOODSCART_LISTENER = 0x10018;
    /**
     * 添加收货地址
     */
    int GET_ADD_ADRESS_LISTENER = 0x10019;
    /**
     * 查看收货地址列表
     */
    int GET_ADRESS_LISTENER = 0x10020;
    /**
     * 查看收货地址详情
     */
    int GET_ADRESS_SHOW_LISTENER = 0x10021;
    /**
     * 删除收货地址
     */
    int DELETE_ADRESS_LISTENER = 0x10022;
    /**
     * 查看个人商品订单
     */
    int GET_ORDER_LIST_LISTENER = 0x10023;
    /**
     * 查看订单详情
     */
    int GET_ORDER_SHOW_LISTENER = 0x10024;
    /**
     * 添加商品订单
     */
    int ADD_ORDER_LISTENER = 0x10025;


    String MESSAGE_EXTRA_KEY = "message_extra_key";
    String MESSAGE_EXTRA_KEY2 = "message_extra_key2";

    String LOGIN_FROM_ME = "login_from_me";

    String DATA_IS_SIAMLL_PIC = "isSmallPic";
    String DATA_FILE_PATH = "file_path";
    String SAVE_FAILED = "神秘力量导致保存失败 ⊙︿⊙";

    /**
     * startActivityForResult
     */
    int REQUEST_CODE = 1;
    int REQUEST_CODE_IMAGE_CUT = 0x9001;

}
