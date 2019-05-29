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
        Properties prop = new Properties();
        try {
            prop.load(JDBCUitls.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}