package servlet;

import dao.respondDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/respondServlet")
public class respondServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reviewid=req.getParameter("reviewid");
        String answerid=req.getParameter("userid");
        String speakid=req.getParameter("speakerid");
        String text=req.getParameter("text");
        new respondDao().respondao(reviewid,Integer.parseInt(speakid),Integer.parseInt(answerid),text);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
