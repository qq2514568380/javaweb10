package example;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.pool.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Example01 {
    public static DataSource ds = null;
    static {
        //获取DBCP数据源的实现类对象
        BasicDataSource dbs = new BasicDataSource();
        dbs.setDriverClassName("com.mysql.jdbc.Driver");
        dbs.setUrl("jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8");
        dbs.setUsername("root");
        dbs.setPassword("password");
        //设置连接池的参数
        dbs.setInitialSize(5);
        dbs.setMaxActive(5);
        ds = dbs;
    }
    public static void main(String[] args) throws SQLException {
        //获取数据库连接对象
        Connection coon = ds.getConnection();
        //获取数据库连接信息
        DatabaseMetaData metaData = coon.getMetaData();
        //打印数据库的连接信息
        System.out.println(metaData.getURL()+"," +
                "UserName="+metaData.getUserName()+","+metaData.getDatabaseProductName());

    }
}
