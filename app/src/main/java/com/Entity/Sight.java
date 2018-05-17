package com.Entity;

import org.litepal.crud.DataSupport;

public class Sight extends DataSupport {
    private int sightid;
    private String sightname;
    private double price;
    private String sightaddress;
    private String content;

    public int getSightid() {
        return sightid;
    }

    public void setSightid(int sightid) {
        this.sightid = sightid;
    }

    public String getSightname() {
        return sightname;
    }

    public void setSightname(String sightname) {
        this.sightname = sightname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSightaddress() {
        return sightaddress;
    }

    public void setSightaddress(String sightaddress) {
        this.sightaddress = sightaddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
