package servlet;

import dao.iodao;
import dao.savedraftdao;
import javaBean.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@WebServlet("/savedraftServlet")
public class savedraftServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String headline=req.getParameter("headline");
        if(headline.isEmpty()){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            headline= format.format(new Date());
        }
        Random r=new Random();
        String id=(r.nextInt(9)+1)+""+r.nextInt(10)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10);
        Person p=(Person)req.getSession().getAttribute("per");
        int userid=p.getId();
        Date time=new Date();
        String zuo=req.getParameter("test-editormd-markdown");
        String you=req.getParameter("test-editormd-html-code");
        String address1="D:\\boke\\c1\\"+id+".txt";
        new iodao().wri(zuo,address1);
        String address2="D:\\boke\\c2\\"+id+".txt";
        new iodao().wri(you,address2);
        new savedraftdao().savedraft(userid,id,time,address1,address2,headline);
        resp.sendRedirect("../blog/savesuccess.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
