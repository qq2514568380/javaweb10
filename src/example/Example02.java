package example;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Example02 {
    public static DataSource ds = null;
    static{
        //新建一个配置对象
        Properties prop = new Properties();
        try{
            InputStream in = new Example02().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
            //把文件以输入流的形式加载到配置文件对象中
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }

    }
    public static void main(String[] args) throws SQLException {
        Connection conn = ds.getConnection();
        //获取连接数据库的信息
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println(metaData.getURL()+",Username = "+metaData.getUserName()+","+metaData.getDriverName());

    }
}
