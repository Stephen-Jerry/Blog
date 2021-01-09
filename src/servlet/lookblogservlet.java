package servlet;

import dao.*;
import javaBean.Blog;
import javaBean.Page;
import javaBean.Speak;
import javaBean.blogUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lookblogServlet")
public class lookblogservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogid=req.getParameter("blogid");
        String bloguserid=req.getParameter("bloguserid");
        String userid=req.getParameter("userid");
        String headline=req.getParameter("headline");
        String publicc=req.getParameter("publicc");
        String look=req.getParameter("look");
        String types=req.getParameter("types");
        String path=new lookblogdao().lookblog(blogid);
        String text=new iodao().red(path);
        String hide=req.getParameter("hide");
        String good=req.getParameter("good");
        String state=req.getParameter("state");
        if(userid == null || "".equals(userid)){

            userid="0";
        }
        if(Integer.parseInt(userid)!=Integer.parseInt(bloguserid)){
            new lookblogdao().look(blogid,Integer.parseInt(bloguserid));
        }
        List<String> list1=new findflagdao().findflag(blogid);
        List<String> list2=new findflagdao().findsort(blogid);
        blogUser bu=new blogUserdao().find(Integer.parseInt(bloguserid));
        boolean isgood=new gooddao().findgood(blogid,Integer.parseInt(userid));
        boolean iscang=new cangdao().findcang(Integer.parseInt(userid),blogid);
        boolean isnotice=new noticedao().isnotice(Integer.parseInt(userid),Integer.parseInt(bloguserid));
        List<Speak> list3=new reviewlistDao().reviewlist(blogid);




        req.getSession().setAttribute("blogid",blogid);
        req.getSession().setAttribute("text",text);
        req.getSession().setAttribute("headline",headline);
        req.getSession().setAttribute("publicc",publicc);
        req.getSession().setAttribute("look",look);
        req.getSession().setAttribute("types",types);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("bloguserid",bloguserid);
        req.getSession().setAttribute("isgood",isgood);
        req.getSession().setAttribute("iscang",iscang);
        req.getSession().setAttribute("isnotice",isnotice);
        req.getSession().setAttribute("hide",hide);
        req.getSession().setAttribute("good",good);
        req.getSession().setAttribute("state",state);
        req.getSession().setAttribute("blogUser",bu);
        req.getSession().setAttribute("flag",list1);
        req.getSession().setAttribute("sort",list2);
        req.getSession().setAttribute("review",list3);
        resp.sendRedirect("../blog/lookblog.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
