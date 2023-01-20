package com.example.repository;

import com.example.domain.SpotifyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<SpotifyUser, Integer> {
   List<SpotifyUser> findByEmailAndPassword(String email, String password);




}
