package servlet;

import dao.looksortDao;
import javaBean.Blog;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lookothersortServlet")
public class lookothersortServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        String sortname=req.getParameter("sortname");
        String userid=req.getParameter("userid");
        String bloguserid=req.getParameter("bloguserid");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Blog> pg=new looksortDao().looksortdao2(Integer.parseInt(nowpage),Integer.parseInt(count),sortname,Integer.parseInt(bloguserid));
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("sortname",sortname);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("bloguserid",bloguserid);

        resp.sendRedirect("../blog/lookothersort.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
