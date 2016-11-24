package com.zn.appseletor.adapter.holder;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zn.appseletor.R;
import com.zn.appseletor.adapter.AppSubItemAdapter;
import com.zn.appseletor.bean.AppBean;

import java.util.List;

/**
 * Created by Zning on 2016/11/3.
 */
public class AppHolder extends RecyclerView.ViewHolder {
    TextView titleTv;
    RecyclerView appRv;

    public AppHolder(View itemView) {
        super(itemView);
        titleTv = (TextView) itemView.findViewById(R.id.item_tv_title);
        appRv = (RecyclerView) itemView.findViewById(R.id.item_rv_app);
        appRv.setLayoutManager(new GridLayoutManager(itemView.getContext(), 3));
    }

    public void setData(String key, List<AppBean> appList) {
        titleTv.setText(key);
        appRv.setAdapter(new AppSubItemAdapter(appList));
    }
}
