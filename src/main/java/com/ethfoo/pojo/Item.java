package com.ethfoo.pojo;

public class Item {
    private Integer id;
    private String title;
    private String image;
    private String info;
    private String content;
    private double price;
    private boolean record;//是否在buyrecord中有记录
    private Integer recordcnt; //有记录的数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRecord() {
        return record;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public Integer getRecordcnt() {
        return recordcnt;
    }

    public void setRecordcnt(Integer recordcnt) {
        this.recordcnt = recordcnt;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", record=" + record +
                ", recordcnt=" + recordcnt +
                '}';
    }
}
