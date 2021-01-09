package dao;

import javaBean.Answer;
import javaBean.Speak;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class reviewlistDao {
    public List<Speak> reviewlist(String blogid){
        try {
            Connection cn= JDBCUtils.getConnection();
            String sql="select * from speak where blogid=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,blogid);
            ResultSet rs=ps.executeQuery();
            List<Speak> list=new ArrayList<>();
            while(rs.next()){
                Speak sp=new Speak();
                sp.setText(rs.getString("text"));
                sp.setSpeakerid(rs.getInt("speakerid"));
                sp.setReviewid(rs.getString("reviewid"));
                sp.setBlogid(rs.getString("blogid"));
                Connection cn2=JDBCUtils.getConnection();
                String sql2="select * from user where id=?";
                PreparedStatement ps2=cn2.prepareStatement(sql2);
                ps2.setInt(1,rs.getInt("speakerid"));
                ResultSet rs2=ps2.executeQuery();
                rs2.next();
                sp.setUsername(rs2.getString("username"));
                sp.setPhoto(rs2.getString("photo"));
                Connection cn3=JDBCUtils.getConnection();
                String sql3="select * from answer where reviewid=?";
                PreparedStatement ps3=cn3.prepareStatement(sql3);
                ps3.setString(1,rs.getString("reviewid"));
                ResultSet rs3=ps3.executeQuery();
                List<Answer> an=new ArrayList<>();
                while(rs3.next()){
                    Answer as=new Answer();
                    as.setAnswerid(rs3.getInt("answerid"));
                    as.setSpeakid(rs3.getInt("speakid"));
                    as.setText(rs3.getString("text"));
                    Connection cn4=JDBCUtils.getConnection();
                    String sql4="select * from user where id=?";
                    PreparedStatement ps4=cn4.prepareStatement(sql4);
                    ps4.setInt(1,rs3.getInt("answerid"));
                    ResultSet rs4=ps4.executeQuery();
                    rs4.next();
                    as.setAnswername(rs4.getString("username"));
                    as.setAnswerphoto(rs4.getString("photo"));
                    Connection cn5=JDBCUtils.getConnection();
                    String sql5="select * from user where id=?";
                    PreparedStatement ps5=cn5.prepareStatement(sql5);
                    ps5.setInt(1,rs3.getInt("speakid"));
                    ResultSet rs5=ps5.executeQuery();
                    rs5.next();
                    as.setSpeakname(rs5.getString("username"));
                    as.setSpeakphoto(rs5.getString("photo"));
                    an.add(as);
                    cn4.close();
                    cn5.close();
                }
                sp.setAnswer(an);
                list.add(sp);
                cn2.close();
                cn3.close();
            }
            cn.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
