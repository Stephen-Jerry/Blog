package servlet;

import dao.iodao;
import dao.savedraftdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/savedraftagainServlet")
public class savedraftagainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String head=req.getParameter("headline");
        String zuo=req.getParameter("test-editormd-markdown");
        String you=req.getParameter("test-editormd-html-code");
        new iodao().wri(zuo,"D:\\boke\\c1\\"+id+".txt");
        new iodao().wri(you,"D:\\boke\\c2\\"+id+".txt");
        new savedraftdao().savedraft2(id,head);
        resp.sendRedirect("../blog/savesuccess.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
