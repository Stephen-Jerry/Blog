package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class recommendDao {
    public void recommenddao(String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="insert into recommend values(?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void recommenddao2(String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="delete from recommend where blogid=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
