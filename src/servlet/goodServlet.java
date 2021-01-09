package servlet;

import dao.gooddao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodServlet")
public class goodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogid=req.getParameter("blogid");
        int flag=Integer.parseInt(req.getParameter("flag"));
        int id=Integer.parseInt(req.getParameter("userid"));
        int id2=Integer.parseInt(req.getParameter("bloguserid"));
        if(flag==0){
            new gooddao().goodadd(blogid,id,id2);
        }

        else{
            new gooddao().goodremove(blogid,id,id2);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
