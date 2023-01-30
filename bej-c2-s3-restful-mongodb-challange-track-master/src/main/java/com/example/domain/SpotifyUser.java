/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class SpotifyUser {
    @Id
    private int uid;
    private String uname;
    private Long mnumber;
    private String email;
    private String password;
private List<SongList> songLists;



    public SpotifyUser() {
    }

    public SpotifyUser(int uid, String uname, Long mnumber, String email, String password, List<SongList> songLists) {
        this.uid = uid;
        this.uname = uname;
        this.mnumber = mnumber;
        this.email = email;
        this.password = password;
        this.songLists = songLists;
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

    public List<SongList> getSongLists() {
        return songLists;
    }

    public void setSongLists(List<SongList> songLists) {
        this.songLists = songLists;
    }

    @Override
    public String toString() {
        return "SpotifyUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", mnumber=" + mnumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", songLists=" + songLists +
                '}';
    }
}
