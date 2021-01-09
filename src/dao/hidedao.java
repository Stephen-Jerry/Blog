package dao;

import javaBean.User;
import util.JDBCUtils;

import java.sql.*;
import java.util.Date;

public class hidedao {

    public int hide(User u){
        Connection cn = null;
        try {
            cn= JDBCUtils.getConnection();
           String sql="insert into user(username,upassword,email,sex,fans,notice,look,register,photo,ismanage) values(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps=cn.prepareStatement(sql);
          ps.setString(1,u.getUsername());
          ps.setString(2,u.getPassword());
          ps.setString(3,u.getEmail());
          ps.setString(4,u.getSex());
          ps.setInt(5,0);
          ps.setInt(6,0);
          ps.setInt(7,0);
          java.util.Date d = new java.util.Date();
          java.sql.Date date = new java.sql.Date(d.getTime());
          ps.setDate(8, date);
          ps.setString(9,"/userhead/0.jpg");
          ps.setInt(10,0);
          ps.executeUpdate();
          String sql2="select id from user where username=?";
          PreparedStatement ps2=cn.prepareStatement(sql2);
          ps2.setString(1,u.getUsername());
          ResultSet rs=ps2.executeQuery();
          rs.next();
          return rs.getInt("id");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(cn!=null) {
                try {
                    cn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return 0;
    }
}
