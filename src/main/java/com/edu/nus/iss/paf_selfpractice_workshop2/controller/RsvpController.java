package com.edu.nus.iss.paf_selfpractice_workshop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.nus.iss.paf_selfpractice_workshop2.model.RSVP;
import com.edu.nus.iss.paf_selfpractice_workshop2.service.RsvpService;

@RestController
@RequestMapping
public class RsvpController {
    
    @Autowired
    RsvpService rsvpService;

    @GetMapping("/rsvp")
    public ResponseEntity<List<RSVP>> getAllRsvp() {
        List<RSVP> rsvpList = rsvpService.getAllRsvp();

        if (rsvpList.isEmpty()) {
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<List<RSVP>>(HttpStatus.NOT_FOUND);
        } else {
            // return ResponseEntity.ok().body(rsvpList);
            return new ResponseEntity<List<RSVP>>(rsvpList, HttpStatus.OK);
        }
    }

    @GetMapping("/{rsvp-name}")
    public ResponseEntity<RSVP> getRsvpById(@PathVariable("rsvp-name") int id) {
        RSVP rsvp = new RSVP();
        rsvp = rsvpService.getRsvpById(id);

        if (rsvp == null) {
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<RSVP>(rsvp, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return ResponseEntity.ok().body(rsvp);
            // return new ResponseEntity<RSVP>(rsvp, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Boolean> saveRsvp(@RequestBody RSVP rsvp) {
        Boolean saved = rsvpService.insertRsvp(rsvp);
        if (saved) {
            return ResponseEntity.ok().body(saved);
        } else {
            return new ResponseEntity<Boolean>(saved, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{rsvp-id}")
    public ResponseEntity<Boolean> updateRsvp(@PathVariable("rsvp-id") int rsvpId, @RequestBody RSVP rsvpInfo) {
        RSVP rsvp = rsvpService.getRsvpById(rsvpId);
        Boolean updated = false;

        if (rsvp != null) {
            updated = rsvpService.updateRsvp(rsvpInfo);
        }

        if (updated) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.ofNullable(updated);
        }
    }

    /*
     * TO ADD ON:
     * 1. Incorporate count into Controller.
     * 2. Based on our RSVP object, check if it exists in record, if yes, update, if no, insert. (Combine into one function)
     */
}
