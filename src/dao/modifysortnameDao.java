package dao;

import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifysortnameDao {
    public void modifysortname(String zsort,String lastname,int userid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="update sort set zsort=? where userid=? AND zsort=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,zsort);
            ps.setInt(2,userid);
            ps.setString(3,lastname);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
