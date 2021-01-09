package servlet;

import dao.managepersonDao;
import dao.searchDao;
import javaBean.Page;
import javaBean.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchresult4")
public class searchresult4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String search=req.getParameter("search");
        String count=req.getParameter("count");
        if(nowpage == null || "".equals(nowpage)){

            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<Person> pg=new searchDao().searchdao4(Integer.parseInt(nowpage),Integer.parseInt(count),search);
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("search",search);
        resp.sendRedirect("/search/searchresult4.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
