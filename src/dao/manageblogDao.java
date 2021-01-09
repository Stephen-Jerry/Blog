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

public class manageblogDao {
    public Page<Blog> manageblog(int page, int count){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from blog where state=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"审核中");
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
            String sql2="select * from blog where state=? order by publicc DESC limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,"审核中");
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
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
    public Page<Blog> manageblog2(int page, int count){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from blog where state=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"通过");
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
            String sql2="select * from blog where state=? order by publicc DESC limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,"通过");
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
            ResultSet rs2=ps2.executeQuery();
            List<Blog> list=new ArrayList<>();
            while(rs2.next()){
                Blog bg=new Blog();
                Connection cn3=JDBCUtils.getConnection();
                String sql3="select * from recommend where blogid=?";
                PreparedStatement ps3=cn3.prepareStatement(sql3);
                ps3.setString(1,rs2.getString("id"));
                ResultSet rs3=ps3.executeQuery();
                if(rs3.next()){
                    bg.setRecommend(1);
                }else{
                    bg.setRecommend(0);
                }
                cn3.close();
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
    public Page<Blog> manageblog3(int page, int count){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from blog";
            PreparedStatement ps=cn.prepareStatement(sql);
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
            String sql2="select * from blog order by publicc DESC limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,(page-1)*count);
            ps2.setInt(2,count);
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
