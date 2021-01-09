package servlet;

import dao.reviewDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/reviewServlet")
public class reviewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String userid=req.getParameter("userid");
            String blogid=req.getParameter("blogid");
            Random r=new Random();
            String reviewid=(r.nextInt(9)+1)+""+r.nextInt(10)+r.nextInt(10)+r.nextInt(10);
            String text=req.getParameter("text");
            new reviewDao().review(reviewid,blogid,Integer.parseInt(userid),text);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
