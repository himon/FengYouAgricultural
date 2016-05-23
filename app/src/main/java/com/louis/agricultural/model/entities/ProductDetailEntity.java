package com.louis.agricultural.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.List;

public class ProductDetailEntity extends BaseEntity {
    private ResultBean result;

    public ResultBean getResult() {
        return this.result;
    }

    public void setResult(ResultBean paramResultBean) {
        this.result = paramResultBean;
    }

    public static class ResultBean
            implements Parcelable {
        public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator() {
            public ProductDetailEntity.ResultBean createFromParcel(Parcel paramAnonymousParcel) {
                return new ProductDetailEntity.ResultBean(paramAnonymousParcel);
            }

            public ProductDetailEntity.ResultBean[] newArray(int paramAnonymousInt) {
                return new ProductDetailEntity.ResultBean[paramAnonymousInt];
            }
        };
        private List<AlbumBean> album;
        private String brand;
        private String category_id;
        private String category_imgurl;
        private String category_name;
        private List<CommentBean> comment;
        private String commentpls;
        private String goods_id;
        private String goods_no;
        private int gwc_sum;
        private String sell_price;
        private String stock_quantity;
        private String title;

        public ResultBean() {
        }

        protected ResultBean(Parcel paramParcel) {
            this.title = paramParcel.readString();
            this.sell_price = paramParcel.readString();
            this.brand = paramParcel.readString();
            this.category_id = paramParcel.readString();
            this.category_imgurl = paramParcel.readString();
            this.category_name = paramParcel.readString();
            this.goods_no = paramParcel.readString();
            this.goods_id = paramParcel.readString();
            this.stock_quantity = paramParcel.readString();
            this.gwc_sum = paramParcel.readInt();
            this.commentpls = paramParcel.readString();
            this.album = paramParcel.createTypedArrayList(AlbumBean.CREATOR);
            this.comment = paramParcel.createTypedArrayList(CommentBean.CREATOR);
        }

        public int describeContents() {
            return 0;
        }

        public List<AlbumBean> getAlbum() {
            return this.album;
        }

        public String getBrand() {
            return this.brand;
        }

        public String getCategory_id() {
            return this.category_id;
        }

        public String getCategory_imgurl() {
            return this.category_imgurl;
        }

        public String getCategory_name() {
            return this.category_name;
        }

        public List<CommentBean> getComment() {
            return this.comment;
        }

        public String getCommentpls() {
            return this.commentpls;
        }

        public String getGoods_id() {
            return this.goods_id;
        }

        public String getGoods_no() {
            return this.goods_no;
        }

        public int getGwc_sum() {
            return this.gwc_sum;
        }

        public String getSell_price() {
            return this.sell_price;
        }

        public String getStock_quantity() {
            return this.stock_quantity;
        }

        public String getTitle() {
            return this.title;
        }

        public void setAlbum(List<AlbumBean> paramList) {
            this.album = paramList;
        }

        public void setBrand(String paramString) {
            this.brand = paramString;
        }

        public void setCategory_id(String paramString) {
            this.category_id = paramString;
        }

        public void setCategory_imgurl(String paramString) {
            this.category_imgurl = paramString;
        }

        public void setCategory_name(String paramString) {
            this.category_name = paramString;
        }

        public void setComment(List<CommentBean> paramList) {
            this.comment = paramList;
        }

        public void setCommentpls(String paramString) {
            this.commentpls = paramString;
        }

        public void setGoods_id(String paramString) {
            this.goods_id = paramString;
        }

        public void setGoods_no(String paramString) {
            this.goods_no = paramString;
        }

        public void setGwc_sum(int paramString) {
            this.gwc_sum = paramString;
        }

        public void setSell_price(String paramString) {
            this.sell_price = paramString;
        }

        public void setStock_quantity(String paramString) {
            this.stock_quantity = paramString;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.title);
            paramParcel.writeString(this.sell_price);
            paramParcel.writeString(this.brand);
            paramParcel.writeString(this.category_id);
            paramParcel.writeString(this.category_imgurl);
            paramParcel.writeString(this.category_name);
            paramParcel.writeString(this.goods_no);
            paramParcel.writeString(this.goods_id);
            paramParcel.writeString(this.stock_quantity);
            paramParcel.writeInt(this.gwc_sum);
            paramParcel.writeString(this.commentpls);
            paramParcel.writeTypedList(this.album);
            paramParcel.writeTypedList(this.comment);
        }

        public static class AlbumBean
                implements Parcelable {
            public static final Parcelable.Creator<AlbumBean> CREATOR = new Parcelable.Creator() {
                public ProductDetailEntity.ResultBean.AlbumBean createFromParcel(Parcel paramAnonymousParcel) {
                    return new ProductDetailEntity.ResultBean.AlbumBean(paramAnonymousParcel);
                }

                public ProductDetailEntity.ResultBean.AlbumBean[] newArray(int paramAnonymousInt) {
                    return new ProductDetailEntity.ResultBean.AlbumBean[paramAnonymousInt];
                }
            };
            private String original_path;

            public AlbumBean() {
            }

            protected AlbumBean(Parcel paramParcel) {
                this.original_path = paramParcel.readString();
            }

            public int describeContents() {
                return 0;
            }

            public String getOriginal_path() {
                return this.original_path;
            }

            public void setOriginal_path(String paramString) {
                this.original_path = paramString;
            }

            public void writeToParcel(Parcel paramParcel, int paramInt) {
                paramParcel.writeString(this.original_path);
            }
        }

        public static class CommentBean
                implements Parcelable {
            public static final Parcelable.Creator<CommentBean> CREATOR = new Parcelable.Creator() {
                public ProductDetailEntity.ResultBean.CommentBean createFromParcel(Parcel paramAnonymousParcel) {
                    return new ProductDetailEntity.ResultBean.CommentBean(paramAnonymousParcel);
                }

                public ProductDetailEntity.ResultBean.CommentBean[] newArray(int paramAnonymousInt) {
                    return new ProductDetailEntity.ResultBean.CommentBean[paramAnonymousInt];
                }
            };
            private String article_id;
            private String id;
            private String is_lock;
            private String user_id;
            private String user_name;

            public CommentBean() {
            }

            protected CommentBean(Parcel paramParcel) {
                this.id = paramParcel.readString();
                this.user_id = paramParcel.readString();
                this.article_id = paramParcel.readString();
                this.user_name = paramParcel.readString();
                this.is_lock = paramParcel.readString();
            }

            public int describeContents() {
                return 0;
            }

            public String getArticle_id() {
                return this.article_id;
            }

            public String getId() {
                return this.id;
            }

            public String getIs_lock() {
                return this.is_lock;
            }

            public String getUser_id() {
                return this.user_id;
            }

            public String getUser_name() {
                return this.user_name;
            }

            public void setArticle_id(String paramString) {
                this.article_id = paramString;
            }

            public void setId(String paramString) {
                this.id = paramString;
            }

            public void setIs_lock(String paramString) {
                this.is_lock = paramString;
            }

            public void setUser_id(String paramString) {
                this.user_id = paramString;
            }

            public void setUser_name(String paramString) {
                this.user_name = paramString;
            }

            public void writeToParcel(Parcel paramParcel, int paramInt) {
                paramParcel.writeString(this.id);
                paramParcel.writeString(this.user_id);
                paramParcel.writeString(this.article_id);
                paramParcel.writeString(this.user_name);
                paramParcel.writeString(this.is_lock);
            }
        }
    }
}