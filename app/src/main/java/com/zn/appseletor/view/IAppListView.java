package com.zn.appseletor.view;

import com.zn.appseletor.bean.AppBean;

import java.util.List;
import java.util.Map;

/**
 * Created by Zning on 2016/11/2.
 */

public interface IAppListView {
    void showAppListMap(Map<String, List<AppBean>> appListMap);
}
