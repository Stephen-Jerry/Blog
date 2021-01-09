package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class savedraftdao {
    public void savedraft(int userid, String id, Date time,String address1,String address2,String headline){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="insert into draft values(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,headline);
            ps.setString(3,address1);
            ps.setString(4,address2);
            ps.setInt(5,userid);
            java.sql.Date date = new java.sql.Date(time.getTime());
            ps.setDate(6,date);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void savedraft2(String id,String head){
        Connection cn= null;
        try {
            cn = JDBCUtils.getConnection();
            String sql="update draft set head=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,head);
            ps.setString(2,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
