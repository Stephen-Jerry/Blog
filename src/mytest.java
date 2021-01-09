import dao.beginDao;
import dao.logindao;
import javaBean.Blog;
import javaBean.Page;
import javaBean.User;
import org.junit.Test;

import javax.swing.*;

public class mytest {
    @Test
    public void Test1(){
        User user=new User("12","11111111","1@w","男");
        Boolean flag=new logindao().login(user,1);
        if(flag){
            System.out.println("用户存在");
        }
        else {
            System.out.println("不存在");
        }
    }
}
