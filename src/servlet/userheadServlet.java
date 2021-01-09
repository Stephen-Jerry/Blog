package servlet;

import dao.persondao;
import util.UPHEADUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userheadServlet")
public class userheadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        try {
            UPHEADUtils.updateHead(req,resp,Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("per",new persondao().person(Integer.parseInt(id)));
        req.getSession().setAttribute("id",id);
        resp.sendRedirect("../mainc/person.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
