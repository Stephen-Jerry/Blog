package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cangdao {
    public void cangadd(int  userid,int bloguserid,String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update blog set hide=hide+1 where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="insert into cang values(?,?)";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,userid);
            ps2.setString(2,blogid);
            ps2.executeUpdate();
            cn2.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void cangremove(int  userid,int bloguserid,String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update blog set hide=hide-1 where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.executeUpdate();
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="delete from cang where id=? AND blogid=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,userid);
            ps2.setString(2,blogid);
            ps2.executeUpdate();
            cn2.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean findcang(int userid,String blogid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="select * from cang where id=? AND blogid=?";
            PreparedStatement ps=cn.prepareStatement(sql);
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
