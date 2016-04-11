package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/3/24.
 */
public class MyOrderEvent {

    private String msg;

    private String orderId;

    private String orderGoodsId;

    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(String orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public MyOrderEvent(String msg) {
        this.msg = msg;
    }
}
