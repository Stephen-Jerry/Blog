package servlet;

import dao.otherpageDao;
import dao.persondao;
import javaBean.Blog;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/otherpageServlet2")
public class otherpageServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        String bloguserid=req.getParameter("bloguserid");
        String userid=req.getParameter("userid");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Blog> pg=new otherpageDao().pagedao2(Integer.parseInt(nowpage),Integer.parseInt(count),Integer.parseInt(bloguserid));
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("bloguserid",bloguserid);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("per",new persondao().person(Integer.parseInt(bloguserid)));
        resp.sendRedirect("/blog/otherblog2.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
