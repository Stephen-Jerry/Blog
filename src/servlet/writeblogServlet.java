package servlet;

import dao.insertlogdao;
import dao.insertsortdao;
import dao.iodao;
import dao.writedao;
import javaBean.Person;

import javax.servlet.HttpConstraintElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@WebServlet("/writeblogServlet")
public class writeblogServlet extends HttpServlet {
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
        String username=p.getUsername();
        Date public1=new Date();
        String types=req.getParameter("type");
        String zuo=req.getParameter("test-editormd-markdown");
        String you=req.getParameter("test-editormd-html-code");
        String address1="D:\\boke\\b1\\"+id+".txt";
        new iodao().wri(zuo,address1);
        String address2="D:\\boke\\b2\\"+id+".txt";
        new iodao().wri(you,address2);
        new writedao().write(id,headline,userid,username,public1,types,address1,address2);
        String[] str1=req.getParameterValues("log");
        if(str1!=null)
        new insertlogdao().insertlog(str1,id,userid);
        String[] str2=req.getParameterValues("sort");
        if(str2!=null)
        new insertsortdao().insertsort(str2,id,userid);
        resp.sendRedirect("/blog/writesuccess.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
