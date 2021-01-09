package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class reviewDao {
    public void review(String reviewid,String blogid,int speakerid,String text){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="insert into speak values(?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ps.setInt(2,speakerid);
            ps.setString(3,text);
            ps.setString(4,reviewid);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
