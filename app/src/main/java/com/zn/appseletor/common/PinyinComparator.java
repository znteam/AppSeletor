package com.zn.appseletor.common;

import com.zn.appseletor.bean.AppBean;

import java.util.Comparator;

/**
 * Created by Zning on 2016/11/2.
 */

public class PinyinComparator implements Comparator<AppBean> {

    public int compare(AppBean o1, AppBean o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }
}