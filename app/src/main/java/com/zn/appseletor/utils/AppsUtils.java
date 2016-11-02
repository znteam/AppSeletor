package com.zn.appseletor.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.zn.appseletor.bean.AppBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zning on 2016/11/2.
 */

public class AppsUtils {

    public static List<AppBean> getAllAppsList(Context mContext) {
        List<AppBean> appList = new ArrayList<>();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager packageManager = mContext.getPackageManager();
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo app : apps) {
            AppBean tmpApp = new AppBean();
            tmpApp.setName(app.loadLabel(packageManager).toString());
            tmpApp.setPkgName(app.activityInfo.packageName);
            appList.add(tmpApp);
        }
        return appList;
    }


}
