package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by lc on 16/2/29.
 * 丰友头条
 */
public class FyttEntity extends BaseEntity{


    /**
     * title : 丰友头条
     * link_url :
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private String title;
        private String link_url;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getTitle() {
            return title;
        }

        public String getLink_url() {
            return link_url;
        }
    }
}
