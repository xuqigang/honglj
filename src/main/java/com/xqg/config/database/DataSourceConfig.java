package com.xqg.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建用户：杨辽
 * 创建时间：2017-02-06 14:16:00
 * 描    述：数据源配置
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean
    @Primary
    public DynamicDataSource dataSource(
            @Value("${spring.datasource.a.url}") String a_primaryUrl,
            @Value("${spring.datasource.a.username}") String a_primaryUsername,
            @Value("${spring.datasource.a.password}") String a_primaryPassword) {

        //数据源-1
        DruidDataSource a_primaryDataSource = getDruidDataSource();
        a_primaryDataSource.setUrl(a_primaryUrl);
        a_primaryDataSource.setUsername(a_primaryUsername);
        a_primaryDataSource.setPassword(a_primaryPassword);


        Map<Object, Object> mapDataSources = new HashMap<>();
        mapDataSources.put(DatabaseType.zichan360_case, a_primaryDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(mapDataSources);
        dataSource.setDefaultTargetDataSource(a_primaryDataSource);
        return dataSource;
    }

    //配置事务管理器
    @Bean("txManager")
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


//    @Value("${spring.datasource.continueOnError}")
//    private String continueOnError;

//    @Value("${spring.datasource.type}")
//    private String type;

//    @Value("${spring.datasource.sql-script-encoding}")
//    private String sql_script_encoding;

    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;

    @Value("${spring.datasource.minIdle}")
    private Integer minIdle;

    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;

    @Value("${spring.datasource.maxWait}")
    private Integer maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private Boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private Boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private Boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${spring.datasource.useGlobalDataSourceStat}")
    private Boolean useGlobalDataSourceStat;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    private DruidDataSource getDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        druidDataSource.setConnectionProperties(connectionProperties);
        druidDataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

}
