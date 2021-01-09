package dao;

import util.JDBCUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class removedraftdao {
    public void removedraft(String id){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="delete from draft where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeUpdate();
            cn.close();
            new File("D:\\boke\\c1\\"+id+".txt").delete();
            new File("D:\\boke\\c2\\"+id+".txt").delete();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
