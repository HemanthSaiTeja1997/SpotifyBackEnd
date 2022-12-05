/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Track {
    @Id
    private int tid;
    private String tname;
    private double trating;
    private Artist artist;

    public Track() {
    }

    public Track(int tid, String tname, double trating, Artist artist) {
        this.tid = tid;
        this.tname = tname;
        this.trating = trating;
        this.artist = artist;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public double getTrating() {
        return trating;
    }

    public void setTrating(double trating) {
        this.trating = trating;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
