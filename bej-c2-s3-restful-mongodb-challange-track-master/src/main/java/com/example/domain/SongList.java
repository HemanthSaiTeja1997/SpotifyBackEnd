/*
 *Author Name :P.Hemanth Sai Teja
 *Date:30-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.domain;

import org.springframework.data.annotation.Id;

public class SongList {
    @Id
    private int songId;
    private String songUrl;

    public SongList() {
    }

    public SongList(int songId, String songUrl) {
        this.songId = songId;
        this.songUrl = songUrl;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "songId=" + songId +
                ", songUrl='" + songUrl + '\'' +
                '}';
    }
}
