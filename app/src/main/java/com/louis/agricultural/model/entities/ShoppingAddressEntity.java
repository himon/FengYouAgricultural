package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/4 9:56
 * @des 收货地址实体
 */
public class ShoppingAddressEntity extends BaseEntity {


    /**
     * id : 9
     * user_id : 3
     * sheng : 河南
     * shi : 洛阳
     * qu : 涧西
     * xiangxi : vvvvv
     * shr : lingery
     * code : 471000
     * phone : 13611111111
     * status : 0
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private String id;
        private String user_id;
        private String sheng;
        private String shi;
        private String qu;
        private String xiangxi;
        private String shr;
        private String code;
        private String phone;
        private String status;
        private boolean check;

        public void setId(String id) {
            this.id = id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setSheng(String sheng) {
            this.sheng = sheng;
        }

        public void setShi(String shi) {
            this.shi = shi;
        }

        public void setQu(String qu) {
            this.qu = qu;
        }

        public void setXiangxi(String xiangxi) {
            this.xiangxi = xiangxi;
        }

        public void setShr(String shr) {
            this.shr = shr;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getSheng() {
            return sheng;
        }

        public String getShi() {
            return shi;
        }

        public String getQu() {
            return qu;
        }

        public String getXiangxi() {
            return xiangxi;
        }

        public String getShr() {
            return shr;
        }

        public String getCode() {
            return code;
        }

        public String getPhone() {
            return phone;
        }

        public String getStatus() {
            return status;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }
}
