package dao;

import javaBean.FanorNotice;
import javaBean.Page;
import javaBean.Person;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class managepersonDao {
    public Page<Person> managepersondao(int page, int count){
        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from user";
            PreparedStatement ps=cn.prepareStatement(sql);
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
            String sql2="select * from user limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,(page-1)*count);
            ps2.setInt(2,count);
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
