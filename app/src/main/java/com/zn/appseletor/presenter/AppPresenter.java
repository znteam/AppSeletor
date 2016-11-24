package com.zn.appseletor.presenter;

import android.content.Context;
import android.util.Log;

import com.zn.appseletor.bean.AppBean;
import com.zn.appseletor.model.AppModel;
import com.zn.appseletor.view.IAppListView;

import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Zning on 2016/11/2.
 */

public class AppPresenter {
    private IAppListView appListView;
    private AppModel appModel;

    public AppPresenter(IAppListView appListView, AppModel appModel) {
        this.appListView = appListView;
        this.appModel = appModel;
    }

    public void getAppList(Context mContext) {
        appModel.loadAppList(mContext).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Map<String, List<AppBean>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Map<String, List<AppBean>> appMap) {
                if (appMap == null || appMap.isEmpty()) {
                    return;
                }
                appListView.showAppListMap(appMap);
            }
        });
    }
}
