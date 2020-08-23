package com.xwtec.dataSource;

/**
 * 使用threadlocal来保存数据源
 * Created by Administrator on 2020/8/23.
 */
public class DynamicDataSourceHolder {
    private static final ThreadLocal<String> DATA_SOURCE_HOLDER = new ThreadLocal<>();

    public static String getDataSource() {
        return DATA_SOURCE_HOLDER.get();
    }

    public static void setDataSource(String dataSourceId) {
        DATA_SOURCE_HOLDER.set(dataSourceId);
    }

    public static void clearDataSource() {
        DATA_SOURCE_HOLDER.remove();
    }
}