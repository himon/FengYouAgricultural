package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public class OrderDetailEntity extends BaseEntity{


    /**
     * id : 118
     * article_id : 109
     * order_id : 83
     * order_status : 2
     * payment_status : 2
     * express_status : 1
     * goods_no :
     * goods_title : 无机肥2
     * img_url : http://115.28.134.18:8087/upload/201603/01/201603011632258818.png
     * goods_price : 100.00
     * quantity : 1
     * point : 0
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String id;
        private String article_id;
        private String order_id;
        private String order_status;
        private String payment_status;
        private String express_status;
        private String goods_no;
        private String goods_title;
        private String img_url;
        private String goods_price;
        private String quantity;
        private String point;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getPayment_status() {
            return payment_status;
        }

        public void setPayment_status(String payment_status) {
            this.payment_status = payment_status;
        }

        public String getExpress_status() {
            return express_status;
        }

        public void setExpress_status(String express_status) {
            this.express_status = express_status;
        }

        public String getGoods_no() {
            return goods_no;
        }

        public void setGoods_no(String goods_no) {
            this.goods_no = goods_no;
        }

        public String getGoods_title() {
            return goods_title;
        }

        public void setGoods_title(String goods_title) {
            this.goods_title = goods_title;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }
    }
}
