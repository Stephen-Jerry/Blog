package javaBean;
/**博主相关信息Bean类*/
public class blogUser {
    private String username;
    private String photo;
    private int fan;
    private int look;
    private int notice;
    private int count;
    public blogUser(){}
    public blogUser(String username, String photo, int fan, int look, int notice, int count) {
        this.username = username;
        this.photo = photo;
        this.fan = fan;
        this.look = look;
        this.notice = notice;
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getFan() {
        return fan;
    }

    public void setFan(int fan) {
        this.fan = fan;
    }

    public int getLook() {
        return look;
    }

    public void setLook(int look) {
        this.look = look;
    }

    public int getNotice() {
        return notice;
    }

    public void setNotice(int notice) {
        this.notice = notice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
