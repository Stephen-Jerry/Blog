package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class lookblogdao {
    public String lookblog(String id){
        Connection cn= null;
        try {
            cn = JDBCUtils.getConnection();
            String sql="select * from blog where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String path=rs.getString("address2");
            cn.close();
            return path;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
    public void look(String blogid,int bloguserid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="update blog set look=look+1 where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="update user set look=look+1 where id=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,bloguserid);
            ps2.executeUpdate();
            cn2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
