package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modifypasswordDao {
    public int modifypassword(int id,String password){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from user where id=? AND upassword=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                cn.close();
                return 1;
            }else{
                cn.close();
                return 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }

    }
    public void modifypassword2(int id,String password){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update user set upassword=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setInt(2,id);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
