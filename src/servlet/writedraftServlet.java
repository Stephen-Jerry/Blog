package servlet;

import dao.iodao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/writedraftServlet")
public class writedraftServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int userid=Integer.parseInt(req.getParameter("userid"));
        String head=req.getParameter("head");
        String text=new iodao().red("D:\\boke\\c1\\"+id+".txt");

        req.getSession().setAttribute("id",id);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("head",head);
        req.getSession().setAttribute("text",text);
        resp.sendRedirect("../blog/writedraft.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
