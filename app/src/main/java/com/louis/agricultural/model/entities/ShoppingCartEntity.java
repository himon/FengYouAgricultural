package com.louis.agricultural.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

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

    public static class ResultEntity implements Parcelable {
        private String id;
        private String user_id;
        private String goods_id;
        private String sum;
        private String title;
        private BigDecimal sell_price;
        private String img_url;
        private String goods_no;
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

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getGoods_no() {
            return goods_no;
        }

        public void setGoods_no(String goods_no) {
            this.goods_no = goods_no;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.user_id);
            dest.writeString(this.goods_id);
            dest.writeString(this.sum);
            dest.writeString(this.title);
            dest.writeSerializable(this.sell_price);
            dest.writeString(this.img_url);
            dest.writeString(this.goods_no);
            dest.writeByte(check ? (byte) 1 : (byte) 0);
        }

        public ResultEntity() {
        }

        protected ResultEntity(Parcel in) {
            this.id = in.readString();
            this.user_id = in.readString();
            this.goods_id = in.readString();
            this.sum = in.readString();
            this.title = in.readString();
            this.sell_price = (BigDecimal) in.readSerializable();
            this.img_url = in.readString();
            this.goods_no = in.readString();
            this.check = in.readByte() != 0;
        }

        public static final Parcelable.Creator<ResultEntity> CREATOR = new Parcelable.Creator<ResultEntity>() {
            public ResultEntity createFromParcel(Parcel source) {
                return new ResultEntity(source);
            }

            public ResultEntity[] newArray(int size) {
                return new ResultEntity[size];
            }
        };
    }
}
