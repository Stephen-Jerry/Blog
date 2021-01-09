package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class noticedao {
    public void noticeadd(int userid,int bloguserid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update user set fans=fans+1 where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,bloguserid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="insert into fan values(?,?)";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,bloguserid);
            ps2.setInt(2,userid);
            ps2.executeUpdate();
            cn2.close();
            Connection cn3=JDBCUtils.getConnection();
            String sql3="insert into notice values(?,?)";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setInt(1,userid);
            ps3.setInt(2,bloguserid);
            ps3.executeUpdate();
            cn3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void noticeremove(int userid,int bloguserid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="update user set fans=fans-1 where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,bloguserid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="delete from fan where id=? AND fanid=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,bloguserid);
            ps2.setInt(2,userid);
            ps2.executeUpdate();
            cn2.close();
            Connection cn3=JDBCUtils.getConnection();
            String sql3="delete from notice where id=? AND noticeid=?";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setInt(1,userid);
            ps3.setInt(2,bloguserid);
            ps3.executeUpdate();
            cn3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public boolean isnotice(int userid,int bloguserid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="select * from fan where id=? ANd fanid=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,bloguserid);
            ps.setInt(2,userid);
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
