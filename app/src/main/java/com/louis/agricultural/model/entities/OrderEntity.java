package com.louis.agricultural.model.entities;

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

    public static class ResultEntity {
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
    }
}
