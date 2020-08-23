package com.xwtec.dataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Administrator on 2020/8/23.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private Logger logger = Logger.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DynamicDataSourceHolder.getDataSource();
        logger.info("获取数据源dataSource：" + dataSource);
        return dataSource;
    }
}