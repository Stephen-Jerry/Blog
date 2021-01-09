package servlet;

import dao.findflagdao;
import dao.iodao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifyblogServlet")
public class modifyblogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogid=req.getParameter("blogid");
        int userid=Integer.parseInt(req.getParameter("userid"));
        String headline=req.getParameter("headline");
        String types=req.getParameter("types");
        List<String> list1=new findflagdao().findflag(blogid);
        List<String> list2=new findflagdao().findsort(blogid);
        String text=new iodao().red("D:\\boke\\b1\\"+blogid+".txt");

        req.getSession().setAttribute("blogid",blogid);
        req.getSession().setAttribute("headline",headline);
        req.getSession().setAttribute("types",types);
        req.getSession().setAttribute("flag",list1);
        req.getSession().setAttribute("flaglength",list1.size());
        req.getSession().setAttribute("sort",list2);
        req.getSession().setAttribute("sortlength",list2.size());
        req.getSession().setAttribute("text",text);
        req.getSession().setAttribute("userid",userid);
        resp.sendRedirect("../blog/modifyblog.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
