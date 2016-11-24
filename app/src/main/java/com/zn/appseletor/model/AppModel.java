package com.zn.appseletor.model;

import android.content.Context;
import android.util.Log;

import com.zn.appseletor.bean.AppBean;
import com.zn.appseletor.utils.AppsUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Zning on 2016/11/2.
 */

public class AppModel {

    private static AppModel appModel;

    public static AppModel getInstance() {
        if (appModel == null) {
            synchronized (AppModel.class) {
                if (appModel == null) {
                    appModel = new AppModel();
                }
            }
        }
        return appModel;
    }

    public Observable<Map<String, List<AppBean>>> loadAppList(final Context mContext) {
        return Observable.defer(new Func0<Observable<Map<String, List<AppBean>>>>() {
            @Override
            public Observable<Map<String, List<AppBean>>> call() {
                Map<String, List<AppBean>> appMap = AppsUtils.getAllAppsMap(AppsUtils.getAllAppsList(mContext));
                return Observable.just(appMap);
            }
        });
    }

}
