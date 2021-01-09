package servlet;

import dao.insertlogdao;
import dao.insertsortdao;
import dao.iodao;
import dao.modifyblogdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitmodifyServlet")
public class submitmodifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String blogid=req.getParameter("blogid");
        String headline=req.getParameter("headline");
        String userid=req.getParameter("userid");
        String zuo=req.getParameter("test-editormd-markdown");
        String you=req.getParameter("test-editormd-html-code");
        String[] str1=req.getParameterValues("log");
        String[] str2=req.getParameterValues("sort");

        new modifyblogdao().changehead(blogid,headline);
        new iodao().wri(zuo,"D:\\boke\\b1\\"+blogid+".txt");
        new iodao().wri(you,"D:\\boke\\b2\\"+blogid+".txt");
        new modifyblogdao().changflag(blogid);
        new modifyblogdao().changsort(blogid);
        if(str1!=null){
            new insertlogdao().insertlog(str1,blogid,Integer.parseInt(userid));
        }
        if(str2!=null){
            new insertsortdao().insertsort(str2,blogid,Integer.parseInt(userid));
        }
        resp.sendRedirect("/blog/writesuccess.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
