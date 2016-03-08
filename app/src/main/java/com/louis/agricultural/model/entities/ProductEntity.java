package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by lc on 16/3/1.
 */
public class ProductEntity extends BaseEntity {


    /**
     * title : 丰友复合肥
     * img_url : http://121.42.15.32:120/upload/201602/22/201602221444550992.jpg
     * sell_price : 90.00
     * brand : 品牌1
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
        private String title;
        private String img_url;
        private String sell_price;
        private String brand;
        private int num;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public void setSell_price(String sell_price) {
            this.sell_price = sell_price;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getTitle() {
            return title;
        }

        public String getImg_url() {
            return img_url;
        }

        public String getSell_price() {
            return sell_price;
        }

        public String getBrand() {
            return brand;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
