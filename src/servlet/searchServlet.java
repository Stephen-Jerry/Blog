package servlet;

import dao.PageDao;
import dao.persondao;
import dao.searchDao;
import javaBean.Blog;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String search=req.getParameter("search");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Blog> pg=new searchDao().searchdao(Integer.parseInt(nowpage),Integer.parseInt(count),search);
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("search",search);
        resp.sendRedirect("/search/searchresult.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
