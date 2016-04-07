package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/4/7.
 */
public class UpdateUserInfoEvent {

    private String msg;

    private int type;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UpdateUserInfoEvent(int type, String msg) {
        this.msg = msg;
        this.type = type;
    }
}
