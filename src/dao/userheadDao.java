package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userheadDao {
    public void userhead(int id,String path){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update user set photo=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,path);
            ps.setInt(2,id);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
