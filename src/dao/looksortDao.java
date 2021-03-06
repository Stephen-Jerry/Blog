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

public class looksortDao {
    public Page<Blog> looksortdao(int page, int count, String sortname,int userid){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from blog where id in(select id from sort where zsort=? AND userid=?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,sortname);
            ps.setInt(2,userid);
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
            String sql2="select * from blog where id in(select id from sort where zsort=? AND userid=?) limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,sortname);
            ps2.setInt(2,userid);
            ps2.setInt(3,(page-1)*count);
            ps2.setInt(4,count);
            ResultSet rs2=ps2.executeQuery();
            List<Blog> list=new ArrayList<>();
            while(rs2.next()){
                Blog bg=new Blog();
                bg.setId(rs2.getString("id"));
                bg.setTypes(rs2.getString("types"));
                bg.setPublicc(rs2.getDate("publicc"));
                bg.setLook(rs2.getInt("look"));
                bg.setHead(rs2.getString("head"));
                bg.setUserid(rs2.getInt("userid"));
                bg.setHide(rs2.getInt("hide"));
                bg.setGood(rs2.getInt("good"));
                bg.setState(rs2.getString("state"));
                bg.setUsername(rs2.getString("username"));
                list.add(bg);
            }
            pg.setList(list);
            cn2.close();
            return pg;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Page<Blog> looksortdao2(int page, int count, String sortname,int userid){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from blog where id in(select id from sort where zsort=? AND userid=?) AND state!=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,sortname);
            ps.setInt(2,userid);
            ps.setString(3,"审核中");
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
            String sql2="select * from blog where id in(select id from sort where zsort=? AND userid=?) AND state!=? limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,sortname);
            ps2.setInt(2,userid);
            ps2.setString(3,"审核中");
            ps2.setInt(4,(page-1)*count);
            ps2.setInt(5,count);
            ResultSet rs2=ps2.executeQuery();
            List<Blog> list=new ArrayList<>();
            while(rs2.next()){
                Blog bg=new Blog();
                bg.setId(rs2.getString("id"));
                bg.setTypes(rs2.getString("types"));
                bg.setPublicc(rs2.getDate("publicc"));
                bg.setLook(rs2.getInt("look"));
                bg.setHead(rs2.getString("head"));
                bg.setUserid(rs2.getInt("userid"));
                bg.setHide(rs2.getInt("hide"));
                bg.setGood(rs2.getInt("good"));
                bg.setState(rs2.getString("state"));
                bg.setUsername(rs2.getString("username"));
                list.add(bg);
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
