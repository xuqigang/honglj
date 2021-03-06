package com.xqg.config.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 创建用户：杨辽
 * 创建时间：2017-02-06 14:16:00
 * 描    述：动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    public static void setDataSourceType(DatabaseType databaseType) {
        contextHolder.set(databaseType);
    }

    public static DatabaseType getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceType();
    }

}
