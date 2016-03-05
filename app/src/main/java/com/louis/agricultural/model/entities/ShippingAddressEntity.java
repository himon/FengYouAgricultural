package com.louis.agricultural.model.entities;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/4 9:56
 * @des 收货地址实体
 */
public class ShippingAddressEntity {

    private String name;

    private String mobile;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
