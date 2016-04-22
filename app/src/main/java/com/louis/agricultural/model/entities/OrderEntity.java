package com.louis.agricultural.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/3 17:47
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class OrderEntity extends BaseEntity {


    /**
     * row_number : 1
     * id : 5
     * order_no : B16031019394804
     * trade_no :
     * user_id : 3
     * user_name : lingery
     * payment_id : 0
     * payment_fee : 0.00
     * payment_status : 1
     * payment_time :
     * express_id : 0
     * express_no :
     * express_fee : 0.00
     * express_status : 0
     * express_time :
     * accept_name : 张浩
     * post_code : 471000
     * telphone : 13460206930
     * mobile :
     * email :
     * area : 河南洛阳涧西
     * address : 唐宫路房地产大厦1203F
     * message :
     * remark :
     * is_invoice : 0
     * invoice_title :
     * invoice_taxes : 0.00
     * payable_amount : 110.00
     * real_amount : 110.00
     * order_amount : 110.00
     * point : 0
     * status : 2
     * add_time : 2016/3/10 19:39:48
     * confirm_time :
     * complete_time :
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity implements Parcelable {
        private String row_number;
        private String id;
        private String order_no;
        private String trade_no;
        private String user_id;
        private String user_name;
        private String payment_id;
        private String payment_fee;
        private String payment_status;
        private String payment_time;
        private String express_id;
        private String express_no;
        private String express_fee;
        private String express_status;
        private String express_time;
        private String accept_name;
        private String post_code;
        private String telphone;
        private String mobile;
        private String email;
        private String area;
        private String address;
        private String message;
        private String remark;
        private String is_invoice;
        private String invoice_title;
        private String invoice_taxes;
        private String payable_amount;
        private String real_amount;
        private String order_amount;
        private String point;
        private String status;
        private String add_time;
        private String confirm_time;
        private String complete_time;

        private String article_id;
        private String img_url;
        private String quantity;
        private String real_price;
        private String goods_price;
        private String Expr1;
        private String goods_title;
        private String order_goods_id;

        public void setRow_number(String row_number) {
            this.row_number = row_number;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public void setPayment_id(String payment_id) {
            this.payment_id = payment_id;
        }

        public void setPayment_fee(String payment_fee) {
            this.payment_fee = payment_fee;
        }

        public void setPayment_status(String payment_status) {
            this.payment_status = payment_status;
        }

        public void setPayment_time(String payment_time) {
            this.payment_time = payment_time;
        }

        public void setExpress_id(String express_id) {
            this.express_id = express_id;
        }

        public void setExpress_no(String express_no) {
            this.express_no = express_no;
        }

        public void setExpress_fee(String express_fee) {
            this.express_fee = express_fee;
        }

        public void setExpress_status(String express_status) {
            this.express_status = express_status;
        }

        public void setExpress_time(String express_time) {
            this.express_time = express_time;
        }

        public void setAccept_name(String accept_name) {
            this.accept_name = accept_name;
        }

        public void setPost_code(String post_code) {
            this.post_code = post_code;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setIs_invoice(String is_invoice) {
            this.is_invoice = is_invoice;
        }

        public void setInvoice_title(String invoice_title) {
            this.invoice_title = invoice_title;
        }

        public void setInvoice_taxes(String invoice_taxes) {
            this.invoice_taxes = invoice_taxes;
        }

        public void setPayable_amount(String payable_amount) {
            this.payable_amount = payable_amount;
        }

        public void setReal_amount(String real_amount) {
            this.real_amount = real_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public void setConfirm_time(String confirm_time) {
            this.confirm_time = confirm_time;
        }

        public void setComplete_time(String complete_time) {
            this.complete_time = complete_time;
        }

        public String getRow_number() {
            return row_number;
        }

        public String getId() {
            return id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public String getTrade_no() {
            return trade_no;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public String getPayment_id() {
            return payment_id;
        }

        public String getPayment_fee() {
            return payment_fee;
        }

        public String getPayment_status() {
            return payment_status;
        }

        public String getPayment_time() {
            return payment_time;
        }

        public String getExpress_id() {
            return express_id;
        }

        public String getExpress_no() {
            return express_no;
        }

        public String getExpress_fee() {
            return express_fee;
        }

        public String getExpress_status() {
            return express_status;
        }

        public String getExpress_time() {
            return express_time;
        }

        public String getAccept_name() {
            return accept_name;
        }

        public String getPost_code() {
            return post_code;
        }

        public String getTelphone() {
            return telphone;
        }

        public String getMobile() {
            return mobile;
        }

        public String getEmail() {
            return email;
        }

        public String getArea() {
            return area;
        }

        public String getAddress() {
            return address;
        }

        public String getMessage() {
            return message;
        }

        public String getRemark() {
            return remark;
        }

        public String getIs_invoice() {
            return is_invoice;
        }

        public String getInvoice_title() {
            return invoice_title;
        }

        public String getInvoice_taxes() {
            return invoice_taxes;
        }

        public String getPayable_amount() {
            return payable_amount;
        }

        public String getReal_amount() {
            return real_amount;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public String getPoint() {
            return point;
        }

        public String getStatus() {
            return status;
        }

        public String getAdd_time() {
            return add_time;
        }

        public String getConfirm_time() {
            return confirm_time;
        }

        public String getComplete_time() {
            return complete_time;
        }

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getReal_price() {
            return real_price;
        }

        public void setReal_price(String real_price) {
            this.real_price = real_price;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getExpr1() {
            return Expr1;
        }

        public void setExpr1(String expr1) {
            Expr1 = expr1;
        }

        public String getGoods_title() {
            return goods_title;
        }

        public void setGoods_title(String goods_title) {
            this.goods_title = goods_title;
        }

        public String getOrder_goods_id() {
            return order_goods_id;
        }

        public void setOrder_goods_id(String order_goods_id) {
            this.order_goods_id = order_goods_id;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.row_number);
            dest.writeString(this.id);
            dest.writeString(this.order_no);
            dest.writeString(this.trade_no);
            dest.writeString(this.user_id);
            dest.writeString(this.user_name);
            dest.writeString(this.payment_id);
            dest.writeString(this.payment_fee);
            dest.writeString(this.payment_status);
            dest.writeString(this.payment_time);
            dest.writeString(this.express_id);
            dest.writeString(this.express_no);
            dest.writeString(this.express_fee);
            dest.writeString(this.express_status);
            dest.writeString(this.express_time);
            dest.writeString(this.accept_name);
            dest.writeString(this.post_code);
            dest.writeString(this.telphone);
            dest.writeString(this.mobile);
            dest.writeString(this.email);
            dest.writeString(this.area);
            dest.writeString(this.address);
            dest.writeString(this.message);
            dest.writeString(this.remark);
            dest.writeString(this.is_invoice);
            dest.writeString(this.invoice_title);
            dest.writeString(this.invoice_taxes);
            dest.writeString(this.payable_amount);
            dest.writeString(this.real_amount);
            dest.writeString(this.order_amount);
            dest.writeString(this.point);
            dest.writeString(this.status);
            dest.writeString(this.add_time);
            dest.writeString(this.confirm_time);
            dest.writeString(this.complete_time);
            dest.writeString(this.article_id);
            dest.writeString(this.img_url);
            dest.writeString(this.quantity);
            dest.writeString(this.real_price);
            dest.writeString(this.goods_price);
            dest.writeString(this.Expr1);
            dest.writeString(this.goods_title);
            dest.writeString(this.order_goods_id);
        }

        public ResultEntity() {
        }

        protected ResultEntity(Parcel in) {
            this.row_number = in.readString();
            this.id = in.readString();
            this.order_no = in.readString();
            this.trade_no = in.readString();
            this.user_id = in.readString();
            this.user_name = in.readString();
            this.payment_id = in.readString();
            this.payment_fee = in.readString();
            this.payment_status = in.readString();
            this.payment_time = in.readString();
            this.express_id = in.readString();
            this.express_no = in.readString();
            this.express_fee = in.readString();
            this.express_status = in.readString();
            this.express_time = in.readString();
            this.accept_name = in.readString();
            this.post_code = in.readString();
            this.telphone = in.readString();
            this.mobile = in.readString();
            this.email = in.readString();
            this.area = in.readString();
            this.address = in.readString();
            this.message = in.readString();
            this.remark = in.readString();
            this.is_invoice = in.readString();
            this.invoice_title = in.readString();
            this.invoice_taxes = in.readString();
            this.payable_amount = in.readString();
            this.real_amount = in.readString();
            this.order_amount = in.readString();
            this.point = in.readString();
            this.status = in.readString();
            this.add_time = in.readString();
            this.confirm_time = in.readString();
            this.complete_time = in.readString();
            this.article_id = in.readString();
            this.img_url = in.readString();
            this.quantity = in.readString();
            this.real_price = in.readString();
            this.goods_price = in.readString();
            this.Expr1 = in.readString();
            this.goods_title = in.readString();
            this.order_goods_id = in.readString();
        }

        public static final Parcelable.Creator<ResultEntity> CREATOR = new Parcelable.Creator<ResultEntity>() {
            public ResultEntity createFromParcel(Parcel source) {
                return new ResultEntity(source);
            }

            public ResultEntity[] newArray(int size) {
                return new ResultEntity[size];
            }
        };
    }
}
