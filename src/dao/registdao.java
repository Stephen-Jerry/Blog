package dao;

import javaBean.User;

import util.JDBCUtils;

import java.sql.*;

public class registdao {
    ResultSet rs1;
    ResultSet rs2;
    public int regist(User registUser){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql1 = "select * from user where username = ? ";
            PreparedStatement ps1=cn.prepareStatement(sql1);
            String sql2 = "select * from user where email = ?";
            PreparedStatement ps2=cn.prepareStatement(sql2);
            ps1.setString(1,registUser.getUsername());
            ps2.setString(1,registUser.getEmail());
            rs1 =ps1.executeQuery();
            rs2 =ps2.executeQuery();
            if(rs1.next()){
                cn.close();
                return 1;
            }else if(rs2.next()){
                cn.close();
                return 2;
            }else{
                cn.close();
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();//记录日志
        }
        return 3;
    }
}

