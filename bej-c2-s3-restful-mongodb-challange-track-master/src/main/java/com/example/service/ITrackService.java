package com.example.service;

import com.example.domain.Track;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;

import java.util.List;
import java.util.Optional;

public interface ITrackService {
    Track saveTrack(Track track) throws TrackExistAlreadyException;

    List<Track> getAllTrack();

    boolean deleteTrack(int tid) throws TrackNotExistException;

    List<Track> getTrackByName(String name);

    Optional<Track> getTrackById(int id);

    List<Track> getTrackByRatingGreaterThan(double rating);

    List<Track> getTrackByArtistName(String aname);


}
