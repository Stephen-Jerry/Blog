package dao;

import javaBean.Blog;
import javaBean.Page;
import javaBean.Person;
import javaBean.Sort;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class searchDao {
    public Page<Blog> searchdao(int page, int count, String name){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            char[] a=name.toCharArray();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<name.length();i++){
                sb.append("%");
                sb.append(a[i]);
            }
            sb.append("%");
            String sql="select count(*) total from blog where head LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
           ps.setString(1,sb.toString());
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
            String sql2="select * from blog where head LIKE ? order by publicc DESC limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,sb.toString());
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
    public Page<Blog> searchdao2(int page, int count, String name){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            char[] a=name.toCharArray();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<name.length();i++){
                sb.append("%");
                sb.append(a[i]);
            }
            sb.append("%");
            String sql="select count(*) total from blogflag where flag LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,sb.toString());
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
            Connection cn3=JDBCUtils.getConnection();
            String sql3="select id from blogflag where flag LIKE ?";
            PreparedStatement ps3=cn3.prepareStatement(sql3);
            ps3.setString(1,sb.toString());
            ResultSet rs3=ps3.executeQuery();
            List<Blog> list=new ArrayList<>();
            while(rs3.next()){
                Connection cn2=JDBCUtils.getConnection();
                String sql2="select * from blog where id=? order by publicc DESC limit ?,?";
                PreparedStatement ps2=cn2.prepareStatement(sql2);
                ps2.setString(1,rs3.getString("id"));
                ps2.setInt(2,(page-1)*count);
                ps2.setInt(3,count);
                ResultSet rs2=ps2.executeQuery();
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
                cn2.close();
            }
            pg.setList(list);
            cn3.close();
            return pg;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Page<Sort> searchdao3(int page, int count, String name){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            char[] a=name.toCharArray();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<name.length();i++){
                sb.append("%");
                sb.append(a[i]);
            }
            sb.append("%");
            String sql="select count(distinct zsort,userid) total from sort where zsort LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,sb.toString());
            ResultSet rs=ps.executeQuery();
            rs.next();
            Page<Sort> pg=new Page<Sort>();
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
            String sql2="select distinct zsort,userid,username from sort,user where zsort LIKE ? AND user.id=sort.userid limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,sb.toString());
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
            ResultSet rs2=ps2.executeQuery();
            List<Sort> list=new ArrayList<>();
            while(rs2.next()){
                Sort st=new Sort();
                st.setSortname(rs2.getString("zsort"));
                st.setSortuserid(rs2.getInt("userid"));
                st.setSortusername(rs2.getString("username"));
                list.add(st);
            }
            pg.setList(list);
            cn2.close();
            return pg;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Page<Person> searchdao4(int page, int count,String name){
        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            char[] a=name.toCharArray();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<name.length();i++){
                sb.append("%");
                sb.append(a[i]);
            }
            sb.append("%");
            String sql="select count(*) total from user where username LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,sb.toString());
            ResultSet rs=ps.executeQuery();
            rs.next();
            Page<Person> pg=new Page<Person>();
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
            String sql2="select * from user where username LIKE ? limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setString(1,sb.toString());
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
            ResultSet rs2=ps2.executeQuery();
            List<Person> list=new ArrayList<>();
            while(rs2.next()){
                Person p=new Person();
                p.setId(rs2.getInt("id"));
                p.setPhoto(rs2.getString("photo"));
                p.setUsername(rs2.getString("username"));
                list.add(p);
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
