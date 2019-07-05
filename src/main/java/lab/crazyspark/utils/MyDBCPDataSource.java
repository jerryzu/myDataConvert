package lab.crazyspark.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyDBCPDataSource {

    // 单例数据源
    public static BasicDataSource DBCPDATASOURCE = getDBCPDataSource();

    private static BasicDataSource getDBCPDataSource() {
        // 加载配置文件
        Properties properties = new Properties();
        try {
            properties.load(MyDBCPDataSource.class.getResourceAsStream("/dbcp.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicDataSource dataSource = new BasicDataSource();
        // 获取配置
        if (properties.isEmpty()) {
            return null;
        }
        // 基础配置
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setDriverClassName(properties.getProperty("driverClassName"));
        // 数据库连接配置，主要由数据库驱动提供
        // dataSource.setDefaultAutoCommit(Boolean.parseBoolean(oracle.jdbc.OracleConnection.CONNECTION_PROPERTY_AUTOCOMMIT_DEFAULT));
        // ...
        // 连接池的相关配置，这部分的默认配置完全由apache-commons-pool组件提供
        // dataSource.setInitialSize(GenericObjectPool.DEFAULT_MIN_IDLE);
        // dataSource.setMaxActive(GenericObjectPool.DEFAULT_MAX_ACTIVE);
        // dataSource.setMaxIdle(GenericObjectPool.DEFAULT_MAX_ACTIVE);
        // dataSource.setMinIdle(GenericObjectPool.DEFAULT_MIN_IDLE);
        // dataSource.setMaxWait(GenericObjectPool.DEFAULT_MAX_WAIT);
        // dataSource.setTestOnBorrow(GenericObjectPool.DEFAULT_TEST_ON_BORROW);
        // dataSource.setTestOnReturn(GenericObjectPool.DEFAULT_TEST_ON_RETURN);
        // dataSource.setTestWhileIdle(GenericObjectPool.DEFAULT_TEST_WHILE_IDLE);
        // 其他配置见 http://commons.apache.org/proper/commons-dbcp/configuration.html
        return dataSource;
    }
}