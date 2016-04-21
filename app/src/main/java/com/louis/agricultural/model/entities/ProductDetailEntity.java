package com.louis.agricultural.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by lc on 16/3/7.
 * 商品详情
 */
public class ProductDetailEntity extends BaseEntity {


    /**
     * title : a
     * sell_price : 100.00
     * brand :
     * album : [{"thumb_path":"http://115.28.134.18:8087/upload/201603/01/thumb_201603011633431811.png"},{"thumb_path":"http://115.28.134.18:8087/upload/201603/01/thumb_201603011633323010.png"}]
     * commentpls : 0
     */

    private ResultEntity result;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public ResultEntity getResult() {
        return result;
    }

    public static class ResultEntity implements Parcelable {
        private String title;
        private String sell_price;
        private String brand;
        private String commentpls;
        private int gwc_sum;
        /**
         * thumb_path : http://115.28.134.18:8087/upload/201603/01/thumb_201603011633431811.png
         */

        private List<AlbumEntity> album;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSell_price(String sell_price) {
            this.sell_price = sell_price;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setCommentpls(String commentpls) {
            this.commentpls = commentpls;
        }

        public void setAlbum(List<AlbumEntity> album) {
            this.album = album;
        }

        public String getTitle() {
            return title;
        }

        public int getGwc_sum() {
            return gwc_sum;
        }

        public void setGwc_sum(int gwc_sum) {
            this.gwc_sum = gwc_sum;
        }

        public String getSell_price() {
            return sell_price;
        }

        public String getBrand() {
            return brand;
        }

        public String getCommentpls() {
            return commentpls;
        }

        public List<AlbumEntity> getAlbum() {
            return album;
        }

        public static class AlbumEntity implements Parcelable {
            private String original_path;

            public String getOriginal_path() {
                return original_path;
            }

            public void setOriginal_path(String original_path) {
                this.original_path = original_path;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.original_path);
            }

            public AlbumEntity() {
            }

            protected AlbumEntity(Parcel in) {
                this.original_path = in.readString();
            }

            public static final Parcelable.Creator<AlbumEntity> CREATOR = new Parcelable.Creator<AlbumEntity>() {
                public AlbumEntity createFromParcel(Parcel source) {
                    return new AlbumEntity(source);
                }

                public AlbumEntity[] newArray(int size) {
                    return new AlbumEntity[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.sell_price);
            dest.writeString(this.brand);
            dest.writeString(this.commentpls);
            dest.writeInt(this.gwc_sum);
            dest.writeTypedList(album);
        }

        public ResultEntity() {
        }

        protected ResultEntity(Parcel in) {
            this.title = in.readString();
            this.sell_price = in.readString();
            this.brand = in.readString();
            this.commentpls = in.readString();
            this.gwc_sum = in.readInt();
            this.album = in.createTypedArrayList(AlbumEntity.CREATOR);
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
