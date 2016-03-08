package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/3/7.
 */
public class ProductDetailEvent {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ProductDetailEvent(String msg) {
        this.msg = msg;
    }
}
