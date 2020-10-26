package example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Example04 {
    public static DataSource ds = null;
    //初始化C3P0数据源
    static{
        ComboPooledDataSource cpds = new ComboPooledDataSource("itcast");
        ds = cpds;
    }
    public static  void main(String[] agrs) throws SQLException {
        System.out.println(ds.getConnection());
    }
}