package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class passDao {
    public void passdao(String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update blog set state=? where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"通过");
            ps.setString(2,blogid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
