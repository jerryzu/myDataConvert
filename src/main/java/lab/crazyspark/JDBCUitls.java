package lab.crazyspark;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * @author Rowand jj jdbc工具类: 采用dbcp连接池作为数据源
 * 
 */
public class JDBCUitls {
    private static DataSource ds = null;
    static {
        // 导入配置信息
        Properties prop = new Properties();
        try {
            prop.load(JDBCUitls.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            // DBCP核心类
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用dbcp获取一个数据源
     * 
     * @return 返回DataSource实例（数据源）
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取一个连接
     * 
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}