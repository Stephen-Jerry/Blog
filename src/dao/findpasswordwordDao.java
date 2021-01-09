package dao;
import org.apache.commons.mail.HtmlEmail;

import java.util.Random;
public class findpasswordwordDao {
    public String sendemail(String emailaddress){
        Random r=new Random();
        String code=r.nextInt(9)+""+r.nextInt(9)+r.nextInt(9)+r.nextInt(9);
        try {
             HtmlEmail email = new HtmlEmail();//不用更改
            email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(emailaddress);// 收件地址

            email.setFrom("3034234495@qq.com", "博客");//此处填邮箱地址和用户名,用户名可以任意填写

            email.setAuthentication("3034234495@qq.com", "mhxzubdykxxhdhfd");//此处填写邮箱地址和客户端授权码

            email.setSubject("验证码");//此处填写邮件名，邮件名可任意填写
            email.setMsg("尊敬的用户您好,您本次的验证码是:" + code);//此处填写邮件内容
            email.send();
           return code;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
