package servlet;

import dao.noticedao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/noticeServlet")
public class noticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flag=Integer.parseInt(req.getParameter("flag"));
        int userid=Integer.parseInt(req.getParameter("userid"));
        int bloguserid=Integer.parseInt(req.getParameter("bloguserid"));
        if(flag==1){
            new noticedao().noticeadd(userid,bloguserid);
        }else{
            new noticedao().noticeremove(userid,bloguserid);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
