package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyblogdao {
    public void changehead(String blogid,String headline){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update blog set head=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,headline);
            ps.setString(2,blogid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void changflag(String blogid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="delete from blogflag where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void changsort(String blogid){
        Connection cn= null;
        try {
            cn = JDBCUtils.getConnection();
            String sql="delete from sort where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
