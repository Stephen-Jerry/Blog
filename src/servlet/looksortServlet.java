package servlet;

import dao.PageDao;
import dao.looksortDao;
import javaBean.Blog;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/looksortServlet")
public class looksortServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        String userid=req.getParameter("userid");
        String sortname=req.getParameter("sortname");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Blog> pg=new looksortDao().looksortdao(Integer.parseInt(nowpage),Integer.parseInt(count),sortname,Integer.parseInt(userid));
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("sortname",sortname);
        resp.sendRedirect("../personnal/looksort.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
