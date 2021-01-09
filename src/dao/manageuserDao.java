package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class manageuserDao {
    public void chudao(int userid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="update user set upassword=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"123456789");
            ps.setInt(2,userid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void removedao(int userid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="delete from user where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,userid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="delete from answer where answerid=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,userid);
            ps2.executeUpdate();
            cn2.close();
            Connection cn3=JDBCUtils.getConnection();
            String sql3="delete from blog where userid=?";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setInt(1,userid);
            ps3.executeUpdate();
            cn3.close();
            Connection cn4=JDBCUtils.getConnection();
            String sql4="delete from blogflag where userid=?";
            PreparedStatement ps4=cn4.prepareStatement(sql4);
            ps4.setInt(1,userid);
            ps4.executeUpdate();
            cn4.close();
            Connection cn5=JDBCUtils.getConnection();
            String sql5="delete from fan where id=?";
            PreparedStatement ps5=cn5.prepareStatement(sql5);
            ps5.setInt(1,userid);
            ps5.executeUpdate();
            cn5.close();
            Connection cn6=JDBCUtils.getConnection();
            String sql6="delete from notice where id=?";
            PreparedStatement ps6=cn6.prepareStatement(sql6);
            ps6.setInt(1,userid);
            ps6.executeUpdate();
            ps6.close();
            Connection cn7=JDBCUtils.getConnection();
            String sql7="delete from sort where userid=?";
            PreparedStatement ps7=cn7.prepareStatement(sql7);
            ps7.setInt(1,userid);
            ps7.executeUpdate();
            cn7.close();
            Connection cn8=JDBCUtils.getConnection();
            String sql8="delete from speak where speakerid=?";
            PreparedStatement ps8=cn8.prepareStatement(sql8);
            ps8.setInt(1,userid);
            ps8.executeUpdate();
            cn8.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
