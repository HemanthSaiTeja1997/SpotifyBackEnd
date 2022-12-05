package com.example.repository;

import com.example.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    List<Track> findByTname(String tname);

    List<Track> findByTratingGreaterThan(double start);

    @Query("{'artist.aname': {$in:[?0]}}")
    List<Track> findAllTrackAname(String aname);


}
