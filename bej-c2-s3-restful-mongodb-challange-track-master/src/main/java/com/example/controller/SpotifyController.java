/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.controller;

import com.example.domain.SongList;
import com.example.domain.SpotifyUser;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;
import com.example.service.ISpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SpotifyController {
    private ISpotifyService iSpotifyService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public SpotifyController(ISpotifyService iSpotifyService) {
        this.iSpotifyService = iSpotifyService;
    }

    @PostMapping("/saveSpotifyUser")
    public ResponseEntity<?> save(@RequestBody SpotifyUser spotifyUser) throws TrackExistAlreadyException {
        try {
            return new ResponseEntity<>(iSpotifyService.saveSpotifyUser(spotifyUser), HttpStatus.CREATED);
        } catch (TrackExistAlreadyException e) {
            throw new TrackExistAlreadyException();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!Try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteTrack/{id}")
    public ResponseEntity<?> deleteFunction(@PathVariable int id) throws TrackNotExistException {
        try {
            iSpotifyService.deleteSpotifyUser(id);
            return new ResponseEntity<>("Track Record Deleted", HttpStatus.OK);
        } catch (TrackNotExistException e) {
            throw new TrackNotExistException();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!Try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchAllSpotifyUsers")
    public ResponseEntity<?> fetch() {
        return new ResponseEntity<>(iSpotifyService.getAllSpotifyUsers(), HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<?> fetch3(@PathVariable int id) {
        return new ResponseEntity<>(iSpotifyService.getTrackById(id), HttpStatus.CREATED);
    }

    @GetMapping("/getbtemail/{email}/{password}")
    public ResponseEntity<?> fetch4(@PathVariable String email, @PathVariable String password) {
        return new ResponseEntity<>(iSpotifyService.findByEmailAndPassword(email, password), HttpStatus.CREATED);
    }



    @PostMapping("/songlist/addsongs/{uid}")
    public ResponseEntity<?> saveSongsToSpotify(@RequestBody SongList songList, @PathVariable int uid) {
//        try {
        System.out.println("uid " + uid);

        responseEntity = new ResponseEntity<>(iSpotifyService.saveSongsToSpotify(songList,uid), HttpStatus.CREATED);
//        } catch (RestaurantNotFoundException e) {
//            System.out.println(e);
//            throw new RestaurantNotFoundException();
//        }

        return responseEntity;
    }

    @GetMapping("/songlist/{uid}")
    public ResponseEntity<?> getAllSongsFromSpotify(@PathVariable int uid) {
//        try {
        System.out.println("uid " + uid);
        responseEntity = new ResponseEntity<>(iSpotifyService.getAllSongsFromSpotify(uid), HttpStatus.OK);
//        } catch (RestaurantNotFoundException e) {
//            throw new RestaurantNotFoundException();
//        }
        return responseEntity;
    }


    @DeleteMapping("/songlist/{uid}/{songId}")
    public ResponseEntity<?> deleteSongFromSpotify(@PathVariable int uid, @PathVariable int songId) {
//        try {
        responseEntity = new ResponseEntity<>(iSpotifyService.deleteSongsFromSpotify(uid, songId), HttpStatus.OK);
//        } catch (RestaurantNotFoundException | MenuListNotFoundException m) {
//            throw new MenuListNotFoundException();
//        }
        return responseEntity;
    }



}
