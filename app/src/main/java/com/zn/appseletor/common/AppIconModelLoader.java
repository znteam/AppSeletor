package com.zn.appseletor.common;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;

/**
 * Created by zning on 2016/5/3.
 */
public class AppIconModelLoader<T> implements ModelLoader<T, T> {

    private static AppIconModelLoader instance;

    private AppIconModelLoader(){
    }

    public static AppIconModelLoader getIns(){
        if (instance == null) {
            synchronized (AppIconModelLoader.class) {
                if (instance == null) {
                    instance = new AppIconModelLoader();
                }
            }
        }
        return instance;
    }



    @Override
    public DataFetcher<T> getResourceFetcher(final T model, int width, int height) {
        return new DataFetcher<T>() {
            @Override
            public T loadData(Priority priority) throws Exception {
                return model;
            }

            @Override
            public void cleanup() {
            }

            @Override
            public String getId() {
                return model.toString();
            }

            @Override
            public void cancel() {
            }
        };
    }
}