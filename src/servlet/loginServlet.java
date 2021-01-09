package servlet;

import dao.logindao;
import dao.persondao;
import javaBean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int username=Integer.parseInt(req.getParameter("username"));
        String password=req.getParameter("password");
        User user=new User();
        user.setPassword(password);
        Boolean flag=new logindao().login(user,username);
        if(flag){
//            req.getSession().setAttribute("per",new persondao().person(username));
            req.getSession().setAttribute("islogin",true);
            req.getSession().setAttribute("id",username);
            req.getSession().setAttribute("per",new persondao().person(username));
            req.getSession().setAttribute("ismanage",new persondao().person(username).getIsmanage());
            resp.sendRedirect("/beginServlet?id="+username);
        }else{
            req.getSession().setAttribute("wrong","帐号或密码错误");
            resp.sendRedirect("/mainc/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
