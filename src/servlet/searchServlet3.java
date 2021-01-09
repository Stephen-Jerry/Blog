package servlet;

import dao.persondao;
import dao.searchDao;
import dao.sortpageDao;
import javaBean.Page;
import javaBean.Sort;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchServlet3")
public class searchServlet3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        String search=req.getParameter("search");
        if(nowpage == null || "".equals(nowpage)){
            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Sort> pg=new searchDao().searchdao3(Integer.parseInt(nowpage),Integer.parseInt(count),search);
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("search",search);
        resp.sendRedirect("/search/searchresult3.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
