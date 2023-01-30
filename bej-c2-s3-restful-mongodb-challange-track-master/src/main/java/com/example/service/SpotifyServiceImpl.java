/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.service;

import com.example.domain.SongList;
import com.example.domain.SpotifyUser;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;
import com.example.proxy.UserProxy;
import com.example.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SpotifyServiceImpl implements ISpotifyService {
    private TrackRepository trackRepository;
private UserProxy userProxy;
    @Autowired
    public SpotifyServiceImpl(TrackRepository trackRepository, UserProxy userProxy) {
        this.trackRepository = trackRepository;
        this.userProxy = userProxy;
    }




    @Override
    public SpotifyUser saveSpotifyUser(SpotifyUser spotifyUser) throws TrackExistAlreadyException {
        if (trackRepository.findById(spotifyUser.getUid()).isPresent()) {
            throw new TrackExistAlreadyException();
        }
        userProxy.saveUser(spotifyUser);
        return trackRepository.save(spotifyUser);
    }

    @Override
    public List<SpotifyUser> getAllSpotifyUsers() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteSpotifyUser(int uid) throws TrackNotExistException {
        if (trackRepository.findById(uid).isEmpty()) {
            throw new TrackNotExistException();
        }
        trackRepository.deleteById(uid);
        return true;
    }

    @Override
    public Optional<SpotifyUser> getTrackById(int id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<SpotifyUser> findByEmailAndPassword(String email, String password) {
        return trackRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public SpotifyUser saveSongsToSpotify(SongList songList, int uid) {
        if (trackRepository.findById(uid).isEmpty()) {
            System.out.println("no songs");

        }
        SpotifyUser spotifyUser = trackRepository.findByUid(uid);
        if (spotifyUser.getSongLists() == null) {
            System.out.println("In repo " + uid);
            spotifyUser.setSongLists(Collections.singletonList(songList));
        } else {
            List<SongList> lists = spotifyUser.getSongLists();
            lists.add(songList);
            spotifyUser.setSongLists(lists);
        }
        return trackRepository.save(spotifyUser);
    }


    @Override
    public List<SongList> getAllSongsFromSpotify(int uid) {
        if (trackRepository.findById(uid).isEmpty()) {
            System.out.println("list is empty");
        }
        return trackRepository.findById(uid).get().getSongLists();
    }


    @Override
    public SpotifyUser deleteSongsFromSpotify(int uid, int songId) {
        boolean songIsPresent = false;
        if (trackRepository.findById(uid).isEmpty()) {
        }
        SpotifyUser spotifyUser = trackRepository.findById(uid).get();
        List<SongList> lists = spotifyUser.getSongLists();
        songIsPresent = lists.removeIf(x -> x.getSongId() == (songId));
        if (!songIsPresent) {
            System.out.println("list is empty");
        }
        spotifyUser.setSongLists(lists);
        return trackRepository.save(spotifyUser);
    }


}
