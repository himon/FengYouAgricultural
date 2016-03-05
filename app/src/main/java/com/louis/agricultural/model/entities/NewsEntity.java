package com.louis.agricultural.model.entities;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 11:37
 * @des 新闻
 */
public class NewsEntity {

    private String title;
    private String content;
    private String img;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
