package dao;

import util.JDBCUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class removeblogdao {
    public void remove(String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="delete from blog where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="delete from blogflag where id=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,blogid);
            ps2.executeUpdate();
            cn2.close();
            Connection cn3=JDBCUtils.getConnection();
            String sql3="delete from cang where blogid=?";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setString(1,blogid);
            ps3.executeUpdate();
            cn3.close();
            Connection cn4=JDBCUtils.getConnection();
            String sql4="delete from sort where id=?";
          PreparedStatement ps4=cn4.prepareStatement(sql4);
          ps4.setString(1,blogid);
          ps4.executeUpdate();
          cn4.close();
          Connection cn5=JDBCUtils.getConnection();
          String sql5="delete from zan where blogid=?";
          PreparedStatement ps5=cn5.prepareStatement(sql5);
          ps5.setString(1,blogid);
          ps5.executeUpdate();
          cn5.close();
          Connection cn6=JDBCUtils.getConnection();
          String sql6="delete from recommend where blogid=?";
          PreparedStatement ps6=cn6.prepareStatement(sql6);
          ps6.setString(1,blogid);
          ps6.executeUpdate();
          cn6.close();
          new File("D:\\boke\\b1\\"+blogid+".txt").delete();
          new File("D:\\boke\\b2\\"+blogid+".txt").delete();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
