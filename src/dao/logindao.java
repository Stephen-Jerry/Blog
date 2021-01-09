package dao;

import javaBean.User;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logindao {
    public Boolean login(User u,int a){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="select * from user where id=? and upassword=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,a);
            ps.setString(2,u.getPassword());
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
