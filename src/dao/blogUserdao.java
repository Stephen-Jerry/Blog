package dao;

import javaBean.blogUser;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class blogUserdao {
    public blogUser find(int userid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from user where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,userid);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String username=rs.getString("username");
            String photo=rs.getString("photo");
            int fan=rs.getInt("fans");
            int look=rs.getInt("look");
            int notice=rs.getInt("notice");
            cn.close();
            Connection cn2=JDBCUtils.getConnection();
            String sql2="select count(*) total from blog where userid=? AND types=?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,userid);
            ps2.setString(2,"原创");
            ResultSet rs2=ps2.executeQuery();
            rs2.next();
            int count=rs2.getInt("total");
            blogUser bu=new blogUser(username,photo,fan,look,notice,count);
            cn2.close();
            return bu;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
