package com.Entity;

import org.litepal.crud.DataSupport;

public class Hotel extends DataSupport {
    private int hotelid;
    private String hotelname;
    private double hotelprice;
    private String hoteladdress;
    private String hotelcontent;

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
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
