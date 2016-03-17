package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 10:54
 * @des 公告
 */
public class AnnouncementEntity extends BaseEntity{


    /**
     * row_number : 1
     * id : 112
     * channel_id : 6
     * category_id : 56
     * title : 最新通知
     * img_url :
     * zhaiyao : 最新通知
     * add_time : 2016/3/10 18:12:03
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private String row_number;
        private String id;
        private String channel_id;
        private String category_id;
        private String title;
        private String img_url;
        private String zhaiyao;
        private String add_time;

        public void setRow_number(String row_number) {
            this.row_number = row_number;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public void setZhaiyao(String zhaiyao) {
            this.zhaiyao = zhaiyao;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getRow_number() {
            return row_number;
        }

        public String getId() {
            return id;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public String getCategory_id() {
            return category_id;
        }

        public String getTitle() {
            return title;
        }

        public String getImg_url() {
            return img_url;
        }

        public String getZhaiyao() {
            return zhaiyao;
        }

        public String getAdd_time() {
            return add_time;
        }
    }
}
