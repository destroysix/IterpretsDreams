package cn.edu.gdpt.iterpretsdreams;

public class XinzhuoBean {
    /**
     * date : 20190628
     * name : 双鱼座
     * datetime : 2019年06月28日
     * all : 40%
     * color : 红色
     * health : 70%
     * love : 40%
     * money : 40%
     * number : 2
     * QFriend : 射手座
     * summary : 今天会有亲戚朋友的来访，或许是和家人之间的沟通一下你的事业发展，不过要是不成熟的就不要表达出来，不然容易被他人否决
     * work : 40%
     * resultcode : 200
     * error_code : 0
     */

    private int date;
    private String name;
    private String datetime;
    private String all;
    private String color;
    private String health;
    private String love;
    private String money;
    private int number;
    private String QFriend;
    private String summary;
    private String work;
    private String resultcode;
    private int error_code;
    private  int drawimg=R.drawable.byz;

    public int getDrawimg() {
        return drawimg;
    }

    public void setDrawimg(int drawimg) {
        this.drawimg = drawimg;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQFriend() {
        return QFriend;
    }

    public void setQFriend(String QFriend) {
        this.QFriend = QFriend;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
