package servlet;

import dao.checkusernameDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkusernameServlet")
public class checkusernameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username=req.getParameter("username");
            String lastname=req.getParameter("lastname");
            String userid=req.getParameter("userid");
            if(!username.equals(lastname)){
                if(new checkusernameDao().checkusername(username)==false){
                    resp.getWriter().write("0");
                }else{
                    new checkusernameDao().modifyusername(username,Integer.parseInt(userid));
                    resp.getWriter().write("1");
                }
            }else{
                resp.getWriter().write("1");
            }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
