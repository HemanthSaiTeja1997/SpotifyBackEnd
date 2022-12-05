/*
 *Author Name :P.Hemanth Sai Teja
 *Date:24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.controller;

import com.example.domain.Track;
import com.example.exception.TrackExistAlreadyException;
import com.example.exception.TrackNotExistException;
import com.example.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private ITrackService iTrackService;

    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }

    @PostMapping("/saveTrack")
    public ResponseEntity<?> save(@RequestBody Track track) throws TrackExistAlreadyException {
        try {
            return new ResponseEntity<>(iTrackService.saveTrack(track), HttpStatus.CREATED);
        } catch (TrackExistAlreadyException e) {
            throw new TrackExistAlreadyException();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!Try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteTrack/{id}")
    public ResponseEntity<?> deleteFunction(@PathVariable int id) throws TrackNotExistException {
        try {
            iTrackService.deleteTrack(id);
            return new ResponseEntity<>("Track Record Deleted", HttpStatus.OK);
        } catch (TrackNotExistException e) {
            throw new TrackNotExistException();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!Try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchTrack")
    public ResponseEntity<?> fetch() {
        return new ResponseEntity<>(iTrackService.getAllTrack(), HttpStatus.CREATED);
    }

    @GetMapping("/fetchTrackByName/{tname}")
    public ResponseEntity<?> fetch1(@PathVariable String tname) {
        return new ResponseEntity<>(iTrackService.getTrackByName(tname), HttpStatus.CREATED);
    }

    @GetMapping("/fetchTrackById/{id}")
    public ResponseEntity<?> fetch3(@PathVariable int id) {
        return new ResponseEntity<>(iTrackService.getTrackById(id), HttpStatus.CREATED);
    }

    @GetMapping("/fetchTrackByAname/{aname}")
    public ResponseEntity<?> fetch2(@PathVariable String aname) {
        return new ResponseEntity<>(iTrackService.getTrackByArtistName(aname), HttpStatus.CREATED);
    }

    @GetMapping("/fetchTrackByRating/{rating}")
    public ResponseEntity<?> fetch5(@PathVariable double rating) {
        return new ResponseEntity<>(iTrackService.getTrackByRatingGreaterThan(rating), HttpStatus.CREATED);
    }

}
