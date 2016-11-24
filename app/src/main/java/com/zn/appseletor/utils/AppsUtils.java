package com.zn.appseletor.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.zn.appseletor.bean.AppBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        String fc;
        for (ResolveInfo app : apps) {
            AppBean tmpApp = new AppBean();
            String appName = app.loadLabel(packageManager).toString().trim();
            tmpApp.setName(appName);
            tmpApp.setPkgName(app.activityInfo.packageName);
            fc = String.valueOf(FirstCharUtils.getFirstLetter(mContext, appName)).toUpperCase();
            if (fc.matches("[A-Z]")) {
                tmpApp.setSortLetters(fc);
            }else{
                tmpApp.setSortLetters("#");
            }
            appList.add(tmpApp);
        }
        return appList;
    }

    public static Map<String, List<AppBean>> getAllAppsMap(List<AppBean> appList){
        if (appList == null || appList.size() == 0) {
            return null;
        }
        Map<String, List<AppBean>> appMap = new TreeMap<>();
        for (AppBean app : appList) {
           String indexStr = String.valueOf(app.getSortLetters().charAt(0));
            if(appMap.containsKey(indexStr)){
                appMap.get(indexStr).add(app);
            }else{
                List tmpList = new ArrayList();
                tmpList.add(app);
                appMap.put(indexStr, tmpList);
            }
        }
        return appMap;
    }
}
