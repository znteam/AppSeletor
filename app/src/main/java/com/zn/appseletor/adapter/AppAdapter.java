package com.zn.appseletor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zn.appseletor.R;
import com.zn.appseletor.adapter.holder.AppHolder;
import com.zn.appseletor.bean.AppBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zning on 2016/11/3.
 */

public class AppAdapter extends RecyclerView.Adapter<AppHolder> {
    private LayoutInflater inflater;
    private List<String> keysList;
    private Map<String, List<AppBean>> appListMap;

    public void setData(Map<String, List<AppBean>> addList) {
        if (addList != null) {
            this.appListMap = addList;
            this.keysList = getKeysList(appListMap);
            notifyDataSetChanged();
        }
    }

    private List<String> getKeysList(Map<String, List<AppBean>> appListMap) {
         Set<String> keysSet = appListMap.keySet();
        List<String> tempList = new ArrayList<>();
        for (String key : keysSet) {
            tempList.add(key);
        }
        return tempList;
    }

    @Override
    public AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = inflater.inflate(R.layout.item_list_app, parent, false);
        return new AppHolder(view);
    }

    @Override
    public void onBindViewHolder(AppHolder holder, int position) {
        String key = keysList.get(position);
        holder.setData(key, appListMap.get(key));
    }

    @Override
    public int getItemCount() {
        return keysList == null ? 0 : keysList.size();
    }
}
