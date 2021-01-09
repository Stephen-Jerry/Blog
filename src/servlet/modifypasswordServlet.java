package servlet;

import dao.hidedao;
import dao.modifypasswordDao;
import dao.registdao;
import javaBean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifypasswordServlet")
public class modifypasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(req.getParameter("username"));
        String pastpassword=req.getParameter("password3");
        String newpassword=req.getParameter("password1");
        String checkCode1=req.getParameter("check");
        String checkCode2= (String) req.getSession().getAttribute("checkCode_session");
        req.getSession().removeAttribute("checkCode_session");
        if(!checkCode1.equalsIgnoreCase(checkCode2)){
            req.getSession().setAttribute("wrong","验证码错误");
            resp.sendRedirect("/mainc/regist.jsp");

        }else{
            int flag=new modifypasswordDao().modifypassword(id,pastpassword);
            if(flag==1){
                new modifypasswordDao().modifypassword2(id,newpassword);
                resp.sendRedirect("/mainc/login.jsp");
            }else{
                req.getSession().setAttribute("wrong","帐号或密码不正确！");
                resp.sendRedirect("/mainc/modifypassword.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
