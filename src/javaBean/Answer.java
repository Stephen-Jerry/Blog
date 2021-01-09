package javaBean;
/** 评论Bean类*/
public class Answer {
    private int speakid;
    private int answerid;
    private String speakname;
    private String speakphoto;
    private String answername;
    private String answerphoto;
    private String text;

    public String getSpeakphoto() {
        return speakphoto;
    }

    public void setSpeakphoto(String speakphoto) {
        this.speakphoto = speakphoto;
    }

    public String getAnswerphoto() {
        return answerphoto;
    }

    public void setAnswerphoto(String answerphoto) {
        this.answerphoto = answerphoto;
    }

    public int getSpeakid() {
        return speakid;
    }

    public void setSpeakid(int speakid) {
        this.speakid = speakid;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public String getSpeakname() {
        return speakname;
    }

    public void setSpeakname(String speakname) {
        this.speakname = speakname;
    }

    public String getAnswername() {
        return answername;
    }

    public void setAnswername(String answername) {
        this.answername = answername;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
