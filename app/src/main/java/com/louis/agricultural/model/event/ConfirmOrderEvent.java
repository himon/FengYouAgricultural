package com.louis.agricultural.model.event;

/**
 * Created by lc on 16/3/10.
 */
public class ConfirmOrderEvent {

    private String msg;

    private String addressId;

    private String address;

    /**
     * 是否是默认地址 1 是, 0 不是
     */
    private String status;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ConfirmOrderEvent(String msg) {
        this.msg = msg;
    }
}
