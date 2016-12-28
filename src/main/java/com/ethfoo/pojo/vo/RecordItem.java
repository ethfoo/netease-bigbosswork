package com.ethfoo.pojo.vo;


import java.util.Date;

public class RecordItem {
    private String title;
    private String image;
    private Date date;
    private int num;
    private double buyprice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(double buyprice) {
        this.buyprice = buyprice;
    }

    @Override
    public String toString() {
        return "RecordItem{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", date=" + date +
                ", num=" + num +
                ", buyprice=" + buyprice +
                '}';
    }
}
