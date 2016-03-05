package com.louis.agricultural.model.entities;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 16:34
 * @des 商品
 */
public class ProductEntity {

    private String title;
    private String price;
    private int num;
    private String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
