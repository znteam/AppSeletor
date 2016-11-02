package com.zn.appseletor.model;

import android.content.Context;

import com.zn.appseletor.bean.AppBean;
import com.zn.appseletor.utils.AppsUtils;

import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Zning on 2016/11/2.
 */

public class AppModel {

    private static AppModel appModel;

    public static AppModel getInstance(){
        if (appModel == null) {
            synchronized (AppModel.class) {
                if (appModel == null) {
                    appModel = new AppModel();
                }
            }
        }
        return appModel;
    }

    public Observable<List<AppBean>> loadAppList(final Context mContext){
        return Observable.defer(new Func0<Observable<List<AppBean>>>() {
            @Override
            public Observable<List<AppBean>> call() {
                return Observable.just(AppsUtils.getAllAppsList(mContext));
            }
        });
    }

}
