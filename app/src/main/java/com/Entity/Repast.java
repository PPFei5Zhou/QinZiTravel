package com.Entity;

import org.litepal.crud.DataSupport;

public class Repast extends DataSupport {
    private int repastid;
    private String repastname;
    private double repastprice;
    private String repastaddress;
    private String repastcontent;

    public int getRepastid() {
        return repastid;
    }

    public void setRepastid(int repastid) {
        this.repastid = repastid;
    }

    public String getRepastname() {
        return repastname;
    }

    public void setRepastname(String repastname) {
        this.repastname = repastname;
    }

    public double getRepastprice() {
        return repastprice;
    }

    public void setRepastprice(double repastprice) {
        this.repastprice = repastprice;
    }

    public String getRepastaddress() {
        return repastaddress;
    }

    public void setRepastaddress(String repastaddress) {
        this.repastaddress = repastaddress;
    }

    public String getRepastcontent() {
        return repastcontent;
    }

    public void setRepastcontent(String repastcontent) {
        this.repastcontent = repastcontent;
    }
}
