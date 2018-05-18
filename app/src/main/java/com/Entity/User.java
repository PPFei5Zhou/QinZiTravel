package com.Entity;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class User extends DataSupport {
    @Column(unique = true, nullable = false)
    private int userid;

    @Column(nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    private String useraddress;

    @Column(unique = true, nullable = false)
    private String phone;

    private int usertype;

    public int getuserid() {
        return userid;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}
