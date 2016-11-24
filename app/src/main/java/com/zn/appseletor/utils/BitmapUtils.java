package com.zn.appseletor.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.zn.appseletor.ui.ZnApplication;

/**
 * Created by zning on 2016/4/26.
 */
public class BitmapUtils {

    public static Drawable getAppIcon(String pkgName) {
        try {
            PackageManager pm = ZnApplication.getContext().getPackageManager();
            return pm.getApplicationIcon(pkgName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        try {
            return drawable == null ? null : ((BitmapDrawable) drawable).getBitmap();
        }catch (Exception e){
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                    drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            //canvas.setBitmap(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        }
    }


}
