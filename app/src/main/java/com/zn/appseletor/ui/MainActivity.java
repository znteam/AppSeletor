package com.zn.appseletor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zn.appseletor.R;
import com.zn.appseletor.bean.AppBean;
import com.zn.appseletor.model.AppModel;
import com.zn.appseletor.presenter.AppPresenter;
import com.zn.appseletor.utils.AppsUtils;
import com.zn.appseletor.view.IAppListView;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Single;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements IAppListView {

    private static final String TAG = "zning";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_tv_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getApp();
            }
        });

        AppPresenter ap = new AppPresenter(this, AppModel.getInstance());
        ap.getAppList(this);

    }

    void getApp(){
        Single<List<AppBean>> single = Single.fromCallable(new Callable<List<AppBean>>() {
            @Override
            public List<AppBean> call() throws Exception {
                return AppsUtils.getAllAppsList(MainActivity.this);
            }
        });
        single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleSubscriber<List<AppBean>>() {

            @Override
            public void onSuccess(List<AppBean> value) {
                for (AppBean bean : value) {
                    Toast.makeText(MainActivity.this, bean.getName(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onNext(" + bean.getName() + ")");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    @Override
    public void showAppList(List<AppBean> appList) {
        for (AppBean bean : appList) {
            Log.d("zning", "onNext(" + bean.getName() + ")");
        }
    }

}
