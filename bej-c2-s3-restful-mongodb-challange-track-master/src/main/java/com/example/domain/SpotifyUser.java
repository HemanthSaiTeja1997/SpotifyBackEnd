/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpotifyUser {
    @Id
    private int uid;
    private String uname;
    private Long mnumber;
    private String email;
    private String password;
    private String pname;

    private String firstsong;
    private String secondsong;
    private String thirdsong;
    private String fourthosong;
    private String fivthsong;



    public SpotifyUser() {
    }

    public SpotifyUser(int uid, String uname, Long mnumber, String email, String password, String pname, String firstsong, String secondsong, String thirdsong, String fourthosong, String fivthsong) {
        this.uid = uid;
        this.uname = uname;
        this.mnumber = mnumber;
        this.email = email;
        this.password = password;
        this.pname = pname;
        this.firstsong = firstsong;
        this.secondsong = secondsong;
        this.thirdsong = thirdsong;
        this.fourthosong = fourthosong;
        this.fivthsong = fivthsong;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getMnumber() {
        return mnumber;
    }

    public void setMnumber(Long mnumber) {
        this.mnumber = mnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFirstsong() {
        return firstsong;
    }

    public void setFirstsong(String firstsong) {
        this.firstsong = firstsong;
    }

    public String getSecondsong() {
        return secondsong;
    }

    public void setSecondsong(String secondsong) {
        this.secondsong = secondsong;
    }

    public String getThirdsong() {
        return thirdsong;
    }

    public void setThirdsong(String thirdsong) {
        this.thirdsong = thirdsong;
    }

    public String getFourthosong() {
        return fourthosong;
    }

    public void setFourthosong(String fourthosong) {
        this.fourthosong = fourthosong;
    }

    public String getFivthsong() {
        return fivthsong;
    }

    public void setFivthsong(String fivthsong) {
        this.fivthsong = fivthsong;
    }

    @Override
    public String toString() {
        return "SpotifyUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", mnumber=" + mnumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pname='" + pname + '\'' +
                ", firstsong='" + firstsong + '\'' +
                ", secondsong='" + secondsong + '\'' +
                ", thirdsong='" + thirdsong + '\'' +
                ", fourthosong='" + fourthosong + '\'' +
                ", fivthsong='" + fivthsong + '\'' +
                '}';
    }
}
