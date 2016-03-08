package com.louis.agricultural.model.entities;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lc on 16/3/7.
 */
public class ShoppingCartEntity extends BaseEntity {


    /**
     * id : 15
     * user_id : 3
     * goods_id : 110
     * sum : 1
     * title : 生物复合肥
     * sell_price : 100.00
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
        private String goods_id;
        private String sum;
        private String title;
        private BigDecimal sell_price;
        private boolean check;

        public void setId(String id) {
            this.id = id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getId() {
            return id;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public String getSum() {
            return sum;
        }

        public String getTitle() {
            return title;
        }

        public BigDecimal getSell_price() {
            return sell_price;
        }

        public void setSell_price(BigDecimal sell_price) {
            this.sell_price = sell_price;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }
}
