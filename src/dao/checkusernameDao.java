package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkusernameDao {
    public Boolean checkusername(String username){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(username) total from user where username=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int total=rs.getInt("total");
            if(total>=1){
                cn.close();
                return false;
            }else{
                cn.close();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public void modifyusername(String username,int userid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="update user set username=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setInt(2,userid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
