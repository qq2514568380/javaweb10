package example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Example03 {
    public  static DataSource ds;
    static{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try{
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8");
            cpds.setUser("root");
            cpds.setPassword("password");
            cpds.setInitialPoolSize(5);
            cpds.setMaxIdleTime(15);
            ds = cpds;
        } catch (Exception e) {
            throw  new ExceptionInInitializerError(e);
        }

    }
    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
