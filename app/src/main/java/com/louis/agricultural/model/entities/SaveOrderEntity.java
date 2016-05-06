package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by lc on 16/5/6.
 */
public class SaveOrderEntity extends BaseEntity {


    /**
     * id : 252
     * goods_no :
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String id;
        private String goods_no;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_no() {
            return goods_no;
        }

        public void setGoods_no(String goods_no) {
            this.goods_no = goods_no;
        }
    }
}
