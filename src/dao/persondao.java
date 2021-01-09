package dao;

import javaBean.Person;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class persondao {
    public Person person(int a){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from user where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,a);
            ResultSet rs= ps.executeQuery();
            rs.next();
            Person p=new Person(rs.getInt("id"),
                    rs.getString("username"),
                    rs.getDate("register"),
                    rs.getString("uname"),
                    rs.getString("sex"),
                    rs.getDate("birthday"),
                    rs.getString("school"),
                    rs.getString("tel"),
                    rs.getString("introduce"),
                    rs.getString("photo"),
                    rs.getInt("ismanage")
                    );
            cn.close();
            return p;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
