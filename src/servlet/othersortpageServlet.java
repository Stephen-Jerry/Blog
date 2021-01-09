package servlet;

import dao.persondao;
import dao.sortpageDao;
import javaBean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/othersortpageServlet")
public class othersortpageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nowpage=req.getParameter("nowpage");
        String count=req.getParameter("count");
        String userid=req.getParameter("userid");
        String bloguserid=req.getParameter("bloguserid");
        if(nowpage == null || "".equals(nowpage)){
            nowpage = "1";
        }


        if(count == null || "".equals(count)){
            count = "5";
        }
        Page<String> pg=new sortpageDao().pagedao(Integer.parseInt(nowpage),Integer.parseInt(count),Integer.parseInt(bloguserid));
        req.getSession().setAttribute("page",pg);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("bloguserid",bloguserid);
        req.getSession().setAttribute("per",new persondao().person(Integer.parseInt(bloguserid)));
        resp.sendRedirect("../blog/othersort.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
