package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/3/8.
 */
public class ShoppingCartEvent {

    private String msg;

    private String id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShoppingCartEvent(String msg) {
        this.msg = msg;
    }
}
