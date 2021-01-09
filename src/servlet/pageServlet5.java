package servlet;

import dao.Page5Dao;
import dao.PageDao;
import dao.persondao;
import javaBean.Blog;
import javaBean.FanorNotice;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pageServlet5")
public class pageServlet5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        String userid=req.getParameter("id");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<FanorNotice> pg=new Page5Dao().pagedao5(Integer.parseInt(nowpage),Integer.parseInt(count),Integer.parseInt(userid));
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("id",userid);
        req.getSession().setAttribute("per",new persondao().person(Integer.parseInt(userid)));
        resp.sendRedirect("/personnal/myfans.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
