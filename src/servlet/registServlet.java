package servlet;

import dao.hidedao;
import dao.registdao;
import javaBean.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/registServlet")
public class registServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password1=req.getParameter("password1");
        String sex=req.getParameter("sex");
        String email=req.getParameter("email");
        String checkCode1=req.getParameter("check");
        String checkCode2= (String) req.getSession().getAttribute("checkCode_session");
        req.getSession().removeAttribute("checkCode_session");
        if(!checkCode1.equalsIgnoreCase(checkCode2)){
            req.getSession().setAttribute("wrong","验证码错误");
            resp.sendRedirect("/mainc/regist.jsp");
        }else{
            User user=new User(username,password1,email,sex);
            registdao r=new registdao();
            int bool=r.regist(user);
            if(bool==1){
                req.getSession().setAttribute("wrong","用户名已存在");
                resp.sendRedirect("/mainc/regist.jsp");
            }else if(bool==2){
                req.getSession().setAttribute("wrong","邮箱已被占用");
                resp.sendRedirect("/mainc/regist.jsp");
            }else{
                System.out.println(user.getUsername()+user.getPassword());
                int a=new hidedao().hide(user);
                req.getSession().setAttribute("id",a);
                req.getSession().setAttribute("username",user.getUsername());
                req.getSession().setAttribute("password",user.getPassword());
                resp.sendRedirect("/mainc/success.jsp");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
