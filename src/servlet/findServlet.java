package servlet;

import dao.findDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code=req.getParameter("code");
        String check=req.getParameter("check");
        String email=req.getParameter("email");
        String username=req.getParameter("username");
        if(!code.equalsIgnoreCase(check)){
            req.getSession().setAttribute("wrong","验证码错误");
            resp.sendRedirect("/mainc/findpassword.jsp");
        }else{
            int flag=new findDao().findDao(Integer.parseInt(username),email);
            if(flag==1){
                String password=new findDao().findDao2(Integer.parseInt(username),email);
                req.getSession().setAttribute("ID",username);
                req.getSession().setAttribute("password",password);
                resp.sendRedirect("/blog/findsuccess.jsp");
            }else{
                req.getSession().setAttribute("wrong","用户名与邮箱不匹配");
                resp.sendRedirect("/mainc/findpassword.jsp");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
