package servlet;

import dao.PageDao;
import dao.manageblogDao;
import dao.persondao;
import javaBean.Blog;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manageblogServlet")
public class manageblogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Blog> pg=new manageblogDao().manageblog(Integer.parseInt(nowpage),Integer.parseInt(count));
        req.getSession().setAttribute("page",pg);
        resp.sendRedirect("/manageblog/manageblog.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
