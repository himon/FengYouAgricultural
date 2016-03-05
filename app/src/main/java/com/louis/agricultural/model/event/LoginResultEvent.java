package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/3/4.
 */
public class LoginResultEvent {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginResultEvent(String msg) {
        this.msg = msg;
    }
}
