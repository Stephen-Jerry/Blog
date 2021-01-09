package servlet;

import dao.cangdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cangServlet")
public class cangServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String blogid=req.getParameter("blogid");
       int flag=Integer.parseInt(req.getParameter("flag"));
       int userid=Integer.parseInt(req.getParameter("userid"));
       int bloguserid=Integer.parseInt(req.getParameter("bloguserid"));
       if(flag==1){
           new cangdao().cangadd(userid,bloguserid,blogid);
       }else{
           new cangdao().cangremove(userid,bloguserid,blogid);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
