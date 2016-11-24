package com.zn.appseletor.adapter.holder;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zn.appseletor.R;
import com.zn.appseletor.bean.AppBean;
import com.zn.appseletor.common.AppIconDecoder;
import com.zn.appseletor.common.AppIconModelLoader;

/**
 * Created by Zning on 2016/11/3.
 */
public class AppSubItemHolder extends RecyclerView.ViewHolder {
    TextView titleTv;
    ImageView picIv;
    private AppIconDecoder mAppIconDecoder;

    public AppSubItemHolder(View itemView) {
        super(itemView);
        titleTv = (TextView) itemView.findViewById(R.id.item_tv_title);
        picIv = (ImageView) itemView.findViewById(R.id.item_iv_pic);

    }

    public void setData(AppBean appBeen) {
        titleTv.setText(appBeen.getName());
        Glide.with(picIv.getContext())
                .using(AppIconModelLoader.getIns(), String.class)
                .from(String.class)
                .as(Drawable.class)
                .decoder(AppIconDecoder.getIns())
                .diskCacheStrategy(DiskCacheStrategy.NONE) // cannot disk cache ApplicationInfo, nor Drawables
                .load(appBeen.getPkgName())
                .into(picIv);
    }
}
