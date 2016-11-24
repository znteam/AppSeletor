package com.zn.appseletor.ui;

import android.app.Application;
import android.content.Context;

/**
 * Created by Zning on 2016/11/16.
 */

public class ZnApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
