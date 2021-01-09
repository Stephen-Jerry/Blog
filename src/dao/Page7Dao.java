package dao;

import javaBean.Blog;
import javaBean.Page;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Page7Dao {
    public Page<Blog> pagedao7(int page, int count, int id){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from cang where id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            Page<Blog> pg=new Page<Blog>();
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
            String sql2="select * from cang where id=? limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,id);
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
            ResultSet rs2=ps2.executeQuery();
            List<Blog> list=new ArrayList<>();
            while(rs2.next()){
                Blog bg=new Blog();
                Connection cn3=JDBCUtils.getConnection();
                String sql3="select * from blog where id=?";
                PreparedStatement ps3=cn3.prepareStatement(sql3);
                ps3.setString(1,rs2.getString("blogid"));
                ResultSet rs3=ps3.executeQuery();
                rs3.next();
                bg.setId(rs3.getString("id"));
                bg.setTypes(rs3.getString("types"));
                bg.setPublicc(rs3.getDate("publicc"));
                bg.setLook(rs3.getInt("look"));
                bg.setHead(rs3.getString("head"));
                bg.setUserid(rs3.getInt("userid"));
                bg.setHide(rs3.getInt("hide"));
                bg.setGood(rs3.getInt("good"));
                bg.setState(rs3.getString("state"));
                bg.setUsername(rs3.getString("username"));
                list.add(bg);
                cn3.close();
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
