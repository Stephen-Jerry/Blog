package servlet;

import dao.beginDao;
import javaBean.Blog;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/beginServlet")
public class beginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag=req.getParameter("flag");
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String ismanage=req.getParameter("ismanage");
        String count=req.getParameter("count");
        String userid=req.getParameter("id");

        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }
        if(flag == null || "".equals(flag)){

            flag = "推荐";
        }
        if(userid == null || "".equals(userid)){

            userid= "0";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        if(flag.equals("推荐")){
            Page<Blog> pg=new beginDao().begindao2(Integer.parseInt(nowpage),Integer.parseInt(count),flag);
            req.getSession().setAttribute("page",pg);
            req.getSession().setAttribute("flag",flag);
            req.getSession().setAttribute("userid",userid);
            req.getSession().setAttribute("ismanage",ismanage);
            resp.sendRedirect("/mainc/begin.jsp");
        }else{
            Page<Blog> pg=new beginDao().begindao(Integer.parseInt(nowpage),Integer.parseInt(count),flag);
            req.getSession().setAttribute("page",pg);
            req.getSession().setAttribute("flag",flag);
            req.getSession().setAttribute("userid",userid);
            req.getSession().setAttribute("ismanage",ismanage);
            resp.sendRedirect("/mainc/begin.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
