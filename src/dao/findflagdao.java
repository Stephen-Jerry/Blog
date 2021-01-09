package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class findflagdao {
    public List<String> findflag(String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from blogflag where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ResultSet rs=ps.executeQuery();
            List<String> l=new ArrayList<>();
            while(rs.next()){
                l.add(rs.getString("flag"));
            }
            cn.close();
            return l;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public List<String> findsort(String blogid){
        try {
            Connection cn=JDBCUtils.getConnection();
            String sql="select * from sort where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ResultSet rs=ps.executeQuery();
            List<String> l=new ArrayList<>();
            while(rs.next()){
                l.add(rs.getString("zsort"));
            }
            cn.close();
            return l;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
