/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.service;

import com.example.domain.SpotifyUser;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;
import com.example.proxy.UserProxy;
import com.example.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
