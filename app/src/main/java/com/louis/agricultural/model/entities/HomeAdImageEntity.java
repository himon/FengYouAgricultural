package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by lc on 16/2/29.
 */
public class HomeAdImageEntity extends BaseEntity {


    /**
     * title : 轮播1
     * img_url : http://121.42.15.32:120/upload/201602/22/201602221022227551.jpg
     * link_url : www.baidu.com
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
        private String img_url;
        private String link_url;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getTitle() {
            return title;
        }

        public String getImg_url() {
            return img_url;
        }

        public String getLink_url() {
            return link_url;
        }
    }
}
