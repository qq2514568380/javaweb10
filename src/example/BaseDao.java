package example;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    //优化查询
    public static Object query(String sql, ResultSetHandler<?> rsh,Object...params ){
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try{
            //获得链接
            conn = JDBCUtils.getConnection();
            psmt = conn.prepareStatement(sql);
            //将参数放进去
            for (int i = 0; params !=null&&i<params.length; i++) {
                psmt.setObject(i+1,params[i]);
            }
            //发送sql
            rs = psmt.executeQuery();
            Object obj = rsh.handle(rs);
            return obj;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(rs,psmt,conn);
        }
        return  rs;
    }
}
