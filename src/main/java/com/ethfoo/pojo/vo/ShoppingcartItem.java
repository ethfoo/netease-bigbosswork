package com.ethfoo.pojo.vo;

public class ShoppingcartItem {
    private int itemid;
    private String title;
    private int num;
    private double price;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingcartItem{" +
                "title='" + title + '\'' +
                ", num='" + num + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
