package com.ethfoo.pojo;

import java.util.Date;

public class Buyrecord {
    private int id;
    private int itemid;
    private double buyprice;
    private int num;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(double buyprice) {
        this.buyprice = buyprice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Buyrecord{" +
                "id=" + id +
                ", itemid=" + itemid +
                ", buyprice=" + buyprice +
                ", num=" + num +
                ", date=" + date +
                '}';
    }
}
