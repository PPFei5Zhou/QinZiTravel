package com.Entity;

import org.litepal.crud.DataSupport;

public class Hotel extends DataSupport {
    private int id;
    private String hotelname;
    private double hotelprice;
    private String hoteladdress;
    private String hotelcontent;

    public int getid() {
        return id;
    }

    public void setid(int hotelid) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public double getHotelprice() {
        return hotelprice;
    }

    public void setHotelprice(double hotelprice) {
        this.hotelprice = hotelprice;
    }

    public String getHoteladdress() {
        return hoteladdress;
    }

    public void setHoteladdress(String hoteladdress) {
        this.hoteladdress = hoteladdress;
    }

    public String getHotelcontent() {
        return hotelcontent;
    }

    public void setHotelcontent(String hotelcontent) {
        this.hotelcontent = hotelcontent;
    }
}
