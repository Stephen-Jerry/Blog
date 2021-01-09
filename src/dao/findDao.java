package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class findDao {
    public int findDao(int id,String email){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from user where id=? AND email=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,email);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
    public String findDao2(int id,String email){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from user where id=? AND email=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,email);
            ResultSet rs=ps.executeQuery();
          rs.next();
          String password=rs.getString("upassword");
          return password;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
