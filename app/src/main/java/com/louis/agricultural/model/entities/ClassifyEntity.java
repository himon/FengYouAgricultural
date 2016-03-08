package com.louis.agricultural.model.entities;

import java.util.List;

/**
 * Created by lc on 16/3/6.
 * 分类Entity
 */
public class ClassifyEntity extends BaseEntity{


    /**
     * id : 54
     * title : 生物肥
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
        private boolean checked;

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }
    }
}
