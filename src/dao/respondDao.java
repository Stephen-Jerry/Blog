package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class respondDao {
    public void respondao(String reviewid,int speakid,int answerid,String text){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="insert into answer values(?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,reviewid);
            ps.setInt(2,speakid);
            ps.setInt(3,answerid);
            ps.setString(4,text);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
