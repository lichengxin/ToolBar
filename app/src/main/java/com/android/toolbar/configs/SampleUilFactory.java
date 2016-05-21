package com.android.toolbar.configs;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by li on 2016/5/21.
 */
public class SampleUilFactory {
    private static ImageLoader sImageLoader;

    public static ImageLoader getImageLoader(Context context) {
        if (sImageLoader == null) {
            DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                    .showImageOnLoading(Drawables.sPlaceholderDrawable)
                    .showImageOnFail(Drawables.sErrorDrawable)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                    .defaultDisplayImageOptions(displayImageOptions)
                    .diskCacheSize(ConfigConstants.MAX_DISK_CACHE_SIZE)
                    .memoryCacheSize(ConfigConstants.MAX_MEMORY_CACHE_SIZE)
                    .build();
            sImageLoader = ImageLoader.getInstance();
            sImageLoader.init(config);
        }
        return sImageLoader;
    }
}
