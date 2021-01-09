package javaBean;

import java.util.Date;
/**用户信息Bean类*/
public class Person {
    private int id;
    private String username;
    private Date register;
    private String uname;
    private  String sex;
    private Date birthday;
    private String school;
    private String tel;
    private String introduce;
    private String photo;
    private int ismanage;
    public Person(){}
    public Person(int id, String username, Date register, String uname, String sex, Date birthday, String school, String tel, String introduce,String photo,int ismanage) {
        this.id = id;
        this.username = username;
        this.register = register;
        this.uname = uname;
        this.sex = sex;
        this.birthday = birthday;
        this.school = school;
        this.tel = tel;
        this.introduce = introduce;
        this.photo=photo;
        this.ismanage=ismanage;
    }

    public int getIsmanage() {
        return ismanage;
    }

    public void setIsmanage(int ismanage) {
        this.ismanage = ismanage;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getRegister() {
        return register;
    }

    public String getUname() {
        return uname;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSchool() {
        return school;
    }

    public String getTel() {
        return tel;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
