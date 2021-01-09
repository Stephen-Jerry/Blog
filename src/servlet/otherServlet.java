package servlet;

import dao.persondao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/otherServlet")
public class otherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bloguserid=Integer.parseInt(req.getParameter("bloguserid"));
        int userid=Integer.parseInt(req.getParameter("userid"));
        req.getSession().setAttribute("per",new persondao().person(bloguserid));
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("bloguserid",bloguserid);
        resp.sendRedirect("../mainc/other.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
