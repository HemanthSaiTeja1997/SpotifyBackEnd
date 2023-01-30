package com.example.service;

import com.example.domain.SongList;
import com.example.domain.SpotifyUser;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;

import java.util.List;
import java.util.Optional;

public interface ISpotifyService {
    SpotifyUser saveSpotifyUser(SpotifyUser spotifyUser) throws TrackExistAlreadyException;

    List<SpotifyUser> getAllSpotifyUsers();

    boolean deleteSpotifyUser(int uid) throws TrackNotExistException;

    Optional<SpotifyUser> getTrackById(int id);
    List<SpotifyUser> findByEmailAndPassword(String email, String password);

    SpotifyUser saveSongsToSpotify(SongList songList,int uid);

   List<SongList> getAllSongsFromSpotify(int uid) ;

    SpotifyUser deleteSongsFromSpotify(int uid,int songId);


}
