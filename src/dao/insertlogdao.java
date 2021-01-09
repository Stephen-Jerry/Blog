package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertlogdao {
    public void insertlog(String[] str,String id,int userid){
        try {
            Connection cn = JDBCUtils.getConnection();
            for(int i=0;i<str.length;i++){
                String sql="insert into blogflag(id,flag,userid) values(?,?,?)";
                PreparedStatement ps=cn.prepareStatement(sql);
                ps.setString(1,id);
                ps.setString(2,str[i]);
                ps.setInt(3,userid);
                ps.executeUpdate();
            }
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
