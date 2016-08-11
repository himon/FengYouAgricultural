package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by lc on 16/7/12.
 */
public class HomeBankEntity extends BaseEntity {


    /**
     * id : 29
     * name : 丰合
     * date : 2016/7/11 9:49:59
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
        private String name;
        private String date;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
