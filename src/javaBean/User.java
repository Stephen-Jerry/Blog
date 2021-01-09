package javaBean;
/**用户Bean类*/

public class User<getter> {
    private String username;
    private String password;
    private String email;
    private String sex;

    public User(){}
    public User(String username, String password, String email, String sex) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
