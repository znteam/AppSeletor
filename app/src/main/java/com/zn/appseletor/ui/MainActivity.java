package com.zn.appseletor.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zn.appseletor.R;
import com.zn.appseletor.adapter.AppAdapter;
import com.zn.appseletor.bean.AppBean;
import com.zn.appseletor.model.AppModel;
import com.zn.appseletor.presenter.AppPresenter;
import com.zn.appseletor.view.IAppListView;

import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements IAppListView {

    private static final String TAG = "zning";
    private RecyclerView contentRv;
    private AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appAdapter = new AppAdapter();
        contentRv = (RecyclerView) findViewById(R.id.main_rv_content);
        contentRv.setLayoutManager(new LinearLayoutManager(this));
        contentRv.setAdapter(appAdapter);

        AppPresenter ap = new AppPresenter(this, AppModel.getInstance());
        ap.getAppList(this);

    }

    @Override
    public void showAppListMap(Map<String, List<AppBean>> appListMap) {
        appAdapter.setData(appListMap);
    }
}
