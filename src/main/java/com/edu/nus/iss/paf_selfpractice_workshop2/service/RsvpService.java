package com.edu.nus.iss.paf_selfpractice_workshop2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.nus.iss.paf_selfpractice_workshop2.model.RSVP;
import com.edu.nus.iss.paf_selfpractice_workshop2.repository.RsvpRepo;

@Service
public class RsvpService {
    
    @Autowired
    RsvpRepo rsvpRepo;

    public List<RSVP> getAllRsvp() {
        return rsvpRepo.getAllRsvp();
    }

    public RSVP getRsvpById(int rsvpId) {
        return rsvpRepo.getRsvpById(rsvpId);
    }

    public Boolean insertRsvp(RSVP rsvp) {
        return rsvpRepo.saveRsvp(rsvp);
    }

    public Boolean updateRsvp(RSVP rsvp) {
        return rsvpRepo.updateRsvp(rsvp);
    }

    public Integer getRsvpCount() {
        return rsvpRepo.getRsvpCount();
    }
}
