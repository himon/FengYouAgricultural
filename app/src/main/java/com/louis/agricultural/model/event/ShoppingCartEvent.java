package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/3/8.
 */
public class ShoppingCartEvent {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ShoppingCartEvent(String msg) {
        this.msg = msg;
    }
}
