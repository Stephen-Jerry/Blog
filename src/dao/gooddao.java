package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gooddao {
    public void goodadd(String blogid,int userid,int bloguserid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update blog set good=good+1 where id=?";
            PreparedStatement ps =cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="insert into zan values(?,?)";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,userid);
            ps2.setString(2,blogid);
            ps2.executeUpdate();
            cn2.close();
            Connection cn3=JDBCUtils.getConnection();
            String sql3="update user set notice=notice+1 where id=?";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setInt(1,bloguserid);
            ps3.executeUpdate();
            cn3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void goodremove(String blogid,int userid,int bloguserid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update blog set good=good-1 where id=?";
            PreparedStatement ps =cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="delete from zan where id=? AND blogid=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,userid);
            ps2.setString(2,blogid);
            ps2.executeUpdate();
            cn2.close();
            Connection cn3=JDBCUtils.getConnection();
            String sql3="update user set notice=notice-1 where id=?";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setInt(1,bloguserid);
            ps3.executeUpdate();
            cn3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public boolean findgood(String blogid,int userid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from zan where id=? AND blogid=?";
            PreparedStatement ps =cn.prepareStatement(sql);
            ps.setInt(1,userid);
            ps.setString(2,blogid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                cn.close();
                return true;
            }else{
                cn.close();
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
}
