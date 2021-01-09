package dao;

import javaBean.Blog;
import javaBean.FanorNotice;
import javaBean.Page;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Page5Dao {
    public Page<FanorNotice> pagedao5(int page, int count, int id){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from fan where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            Page<FanorNotice> pg=new Page<FanorNotice>();
            int total=rs.getInt("total");
            pg.setTotalcount(total);
            pg.setNowpage(page);
            pg.setCount(count);
            int totalpage;
            if(total%count==0)
                totalpage=total/count;
            else
                totalpage=total/count+1;
            pg.setTotalpage(totalpage);
            cn.close();

            Connection cn2=JDBCUtils.getConnection();
            String sql2="select * from fan where id=? limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,id);
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
            ResultSet rs2=ps2.executeQuery();
            List<FanorNotice> list=new ArrayList<>();
            while(rs2.next()){
                FanorNotice fn=new FanorNotice();
                fn.setId(rs2.getInt("fanid"));
                Connection cn3=JDBCUtils.getConnection();
                String sql3="SELECT * from user where id=?";
                PreparedStatement ps3=cn3.prepareStatement(sql3);
                ps3.setInt(1,rs2.getInt("fanid"));
                ResultSet rs3=ps3.executeQuery();
                rs3.next();
                fn.setUsername(rs3.getString("username"));
                fn.setTouxiang(rs3.getString("photo"));
                cn3.close();
                list.add(fn);
            }
            pg.setList(list);
            cn2.close();
            return pg;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
