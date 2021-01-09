package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class modifyinformationDao {
    public void modifyinformation(String uname, Date birthday,String tel,String school,String introduce,int userid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update user set uname=?,birthday=?,tel=?,school=?,introduce=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,uname);
            java.sql.Date date=null;
            if(birthday!=null){
                date = new java.sql.Date(birthday.getTime());//会丢失时分秒
            }

            ps.setDate(2, date);
            ps.setString(3,tel);
            ps.setString(4,school);
            ps.setString(5,introduce);
            ps.setInt(6,userid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
