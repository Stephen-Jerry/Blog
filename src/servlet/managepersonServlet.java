package servlet;

import dao.Page6Dao;
import dao.managepersonDao;
import dao.persondao;
import javaBean.FanorNotice;
import javaBean.Page;
import javaBean.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/managepersonServlet")
public class managepersonServlet extends HttpServlet {
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
        Page<Person> pg=new managepersonDao().managepersondao(Integer.parseInt(nowpage),Integer.parseInt(count));
        req.getSession().setAttribute("page",pg);
        resp.sendRedirect("/manageblog/manageuser.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
