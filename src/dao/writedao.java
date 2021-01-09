package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class writedao {
    public void write(String id, String head, int userid, String username, Date publicc,String types,String address1,String address2){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="insert into blog(id,head,userid,username,publicc,types,look,good,hide,critic,address1,address2,state) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,head);
            ps.setInt(3,userid);
            ps.setString(4,username);
            java.sql.Date date = new java.sql.Date(publicc.getTime());
            ps.setDate(5,date);
            ps.setString(6,types);
            ps.setInt(7,0);
            ps.setInt(8,0);
            ps.setInt(9,0);
            ps.setInt(10,0);
            ps.setString(11,address1);
            ps.setString(12,address2);
            ps.setString(13,"审核中");
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
