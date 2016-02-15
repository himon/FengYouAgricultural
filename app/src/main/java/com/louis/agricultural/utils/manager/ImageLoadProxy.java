package com.louis.agricultural.utils.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.louis.agricultural.BuildConfig;
import com.louis.agricultural.R;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;


/**
 * Created by zhaokaiqiang on 15/11/7.
 */
public class ImageLoadProxy {

    private static final int MAX_DISK_CACHE = 1024 * 1024 * 50;
    private static final int MAX_MEMORY_CACHE = 1024 * 1024 * 10;

    private static boolean isShowLog = false;

    private static ImageLoader imageLoader;

    public static ImageLoader getImageLoader() {

        if (imageLoader == null) {
            synchronized (ImageLoadProxy.class) {
                imageLoader = ImageLoader.getInstance();
            }
        }

        return imageLoader;
    }

    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder build = new ImageLoaderConfiguration.Builder(context);
        build.tasksProcessingOrder(QueueProcessingType.LIFO);
        build.diskCacheSize(MAX_DISK_CACHE);
        build.memoryCacheSize(MAX_MEMORY_CACHE);
        build.memoryCache(new LruMemoryCache(MAX_MEMORY_CACHE));

        if (BuildConfig.DEBUG && isShowLog) {
            build.writeDebugLogs();
        }
        getImageLoader().init(build.build());
    }

    /**
     *
     *
     * @param url
     * @param target
     * @param options
     */
    public static void displayImage(String url, ImageView target, DisplayImageOptions options) {
        imageLoader.displayImage(url, target, options);
    }

    /**
     *
     *
     * @param url
     * @param target
     */
    public static void displayHeadIcon(String url, ImageView target) {
        imageLoader.displayImage(url, target, getOptions4Header());

    }

    /**
     *
     *
     * @param url
     * @param target
     * @param loadingListener
     */
    public static void displayImage4Detail(String url, ImageView target, SimpleImageLoadingListener loadingListener) {
        imageLoader.displayImage(url, target, getOption4ExactlyType(), loadingListener);
    }

    /**
     *
     *
     * @param url
     * @param target
     * @param loadingResource
     * @param loadingListener
     * @param progressListener
     */
    public static void displayImageList(String url, ImageView target, int loadingResource, SimpleImageLoadingListener loadingListener, ImageLoadingProgressListener progressListener) {
        imageLoader.displayImage(url, target, getOptions4PictureList(loadingResource), loadingListener, progressListener);
    }

    /**
     *
     *
     * @param url
     * @param target
     * @param loadingResource
     */
    public static void displayImageWithLoadingPicture(String url, ImageView target, int loadingResource) {
        imageLoader.displayImage(url, target, getOptions4PictureList(loadingResource));
    }

    /**
     *
     *
     * @param url
     * @param loadingListener
     */
    public static void loadImageFromLocalCache(String url, SimpleImageLoadingListener loadingListener) {
        imageLoader.loadImage(url, getOption4ExactlyType(), loadingListener);
    }

    /**
     *
     *
     * @return
     */
    public static DisplayImageOptions getOption4ExactlyType() {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .resetViewBeforeLoading(true)
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .build();
    }

    /**
     *
     *
     * @return
     */
    public static DisplayImageOptions getOptions4Header() {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .build();
    }

    /**
     * {@link com.nostra13.universalimageloader.core.DisplayImageOptions.Builder#resetViewBeforeLoading} = true
     *
     * @param loadingResource
     * @return
     */
    public static DisplayImageOptions getOptions4PictureList(int loadingResource) {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .resetViewBeforeLoading(true)
                .showImageOnLoading(loadingResource)
                .showImageForEmptyUri(loadingResource)
                .showImageOnFail(loadingResource)
                .build();
    }

}
