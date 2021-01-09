package servlet;

import dao.modifyinformationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/modifyinformationServlet")
public class modifyinformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getParameter("uname");
        String createTime=req.getParameter("birthday");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        if(createTime!=null){
            try {
                date=sdf.parse(createTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
//        Date birthday=null;
//        if(createTime!=null){
//            birthday=new Date(createTime);
//        }
        String school=req.getParameter("school");
        String tel=req.getParameter("tel");
        String introduce=req.getParameter("introduce");
        String userid=req.getParameter("userid");
        new modifyinformationDao().modifyinformation(uname,date,tel,school,introduce,Integer.parseInt(userid));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
