/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.service;

import com.example.domain.Track;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;
import com.example.proxy.UserProxy;
import com.example.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements ITrackService {
    private TrackRepository trackRepository;
private UserProxy userProxy;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository, UserProxy userProxy) {
        this.trackRepository = trackRepository;
        this.userProxy = userProxy;
    }




    @Override
    public Track saveTrack(Track track) throws TrackExistAlreadyException {
        if (trackRepository.findById(track.getTid()).isPresent()) {
            throw new TrackExistAlreadyException();
        }
        userProxy.saveUser(track);
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int tid) throws TrackNotExistException {
        if (trackRepository.findById(tid).isEmpty()) {
            throw new TrackNotExistException();
        }
        trackRepository.deleteById(tid);
        return true;
    }

    @Override
    public List<Track> getTrackByName(String name) {
        return trackRepository.findByTname(name);
    }

    @Override
    public Optional<Track> getTrackById(int id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getTrackByRatingGreaterThan(double rating) {
        return trackRepository.findByTratingGreaterThan(rating);
    }


    @Override
    public List<Track> getTrackByArtistName(String aname) {
        return trackRepository.findAllTrackAname(aname);
    }
}
