package com.zn.appseletor.common;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;
import com.zn.appseletor.utils.BitmapUtils;

import java.io.IOException;

/**
 * Created by zning on 2016/5/3.
 */
public class AppIconDecoder implements ResourceDecoder<String, Drawable> {
    private static AppIconDecoder instance;

    private AppIconDecoder() {
    }

    public static AppIconDecoder getIns(){
        if (instance == null) {
            synchronized (AppIconDecoder.class) {
                if (instance == null) {
                    instance = new AppIconDecoder();
                }
            }
        }
        return instance;
    }

    @Override
    public Resource<Drawable> decode(String source, int width, int height) throws IOException {
        Drawable icon = BitmapUtils.getAppIcon(source);
        return new DrawableResource<Drawable>(icon) {
            @Override
            public int getSize() {
                if (drawable instanceof BitmapDrawable) {
                    return Util.getBitmapByteSize(BitmapUtils.drawableToBitmap(drawable));
                } else {
                    return 1;
                }
            }

            @Override
            public void recycle() {
            }
        };
    }

    @Override
    public String getId() {
        return "AppIconDecoder";
    }
}