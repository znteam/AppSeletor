package com.zn.appseletor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zn.appseletor.R;
import com.zn.appseletor.adapter.holder.AppHolder;
import com.zn.appseletor.adapter.holder.AppSubItemHolder;
import com.zn.appseletor.bean.AppBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zning on 2016/11/3.
 */

public class AppSubItemAdapter extends RecyclerView.Adapter<AppSubItemHolder> {
    private LayoutInflater inflater;
    private List<AppBean> appList;

    public AppSubItemAdapter(List<AppBean> appList) {
        this.appList = appList;
    }

    @Override
    public AppSubItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = inflater.inflate(R.layout.item_list_app_sub, parent, false);
        return new AppSubItemHolder(view);
    }

    @Override
    public void onBindViewHolder(AppSubItemHolder holder, int position) {
        AppBean appBean = appList.get(position);
        holder.setData(appBean);
    }

    @Override
    public int getItemCount() {
        return appList == null ? 0 : appList.size();
    }
}
