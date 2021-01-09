package dao;

import javaBean.Blog;
import javaBean.Draft;
import javaBean.Page;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Page4Dao {
    public Page<Draft> pagedao4(int page, int count, int id){

        try {
            if(page<=0){
                page=1;
            }
            Connection cn= JDBCUtils.getConnection();
            String sql="select count(*) total from draft where userid=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            Page<Draft> pg=new Page<Draft>();
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
            String sql2="select * from draft where userid=? order by time DESC limit ?,?";
            PreparedStatement ps2=cn2.prepareStatement(sql2);
            ps2.setInt(1,id);
            ps2.setInt(2,(page-1)*count);
            ps2.setInt(3,count);
            ResultSet rs2=ps2.executeQuery();
            List<Draft> list=new ArrayList<>();
            while(rs2.next()){
                Draft df=new Draft();
                df.setHead(rs2.getString("head"));
                df.setId(rs2.getString("id"));
                df.setTime(rs2.getDate("time"));
                df.setUserid(rs2.getInt("userid"));
                list.add(df);
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
