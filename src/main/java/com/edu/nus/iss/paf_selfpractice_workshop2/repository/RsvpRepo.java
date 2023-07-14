package com.edu.nus.iss.paf_selfpractice_workshop2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edu.nus.iss.paf_selfpractice_workshop2.model.RSVP;

@Repository
public class RsvpRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String getAllRsvpSQL = "select * from rsvp";
    private final String getRsvpByName = "select * from rsvp where rsvp_name = ?";
    private final String insertRsvpSQL = "insert into rsvp (rsvp_name, rsvp_email, rsvp_phone, confirmation_date, comments) values (?, ?, ?, ?, ?)";
    private final String updateRsvpSQL = "update rsvp set rsvp_name = ?, rsvp_email = ?, rsvp_phone = ?, comments = ? where rsvp_id = ?";
    private final String rsvpCountSQL = "select count(*) from rsvp";

    public List<RSVP> getAllRsvp() {
        List<RSVP> rsvpList = new ArrayList<RSVP>();

        // String -> Key (Column Name), Object -> Value (Cell Value)
        /*
         * Q: How do we convert (deserialize) a Map<String, Object> into a RSVP object
         * A: One way is to get the values you need for RSVP, and call the constructor of RSVP to get an object
         */
        // List<Map<String, Object>> rsvpRawList = jdbcTemplate.queryForList(getAllRsvpSQL);

        // for (Map<String, Object> rsvpRaw: rsvpRawList) {
        //     RSVP rsvpObject = RSVP.fromMap(rsvpRaw);
        //     rsvpList.add(rsvpObject);
        // }
        // Alternative Method 1
        rsvpList = jdbcTemplate.query(getAllRsvpSQL, BeanPropertyRowMapper.newInstance(RSVP.class));
        System.out.println(rsvpList);

        return rsvpList;
    }

    public RSVP getRsvpById(int rsvpId) {
        RSVP rsvp = new RSVP();
        // rsvp = jdbcTemplate.queryForObject(getRsvpByName, RSVP.class);
        rsvp = jdbcTemplate.queryForObject(getRsvpByName, BeanPropertyRowMapper.newInstance(RSVP.class), rsvpId);
        return rsvp;
    }

    public Boolean saveRsvp(RSVP rsvp) {
        int saved = 0;
        saved = jdbcTemplate.update(insertRsvpSQL, 
            rsvp.getRsvpName(),
            rsvp.getRsvpEmail(),
            rsvp.getRsvpPhone(),
            rsvp.getConfirmationDate(),
            rsvp.getComments());

        if (saved > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateRsvp(RSVP rsvp) {
        int saved = 0;

        saved = jdbcTemplate.update(updateRsvpSQL, 
            rsvp.getRsvpName(),
            rsvp.getRsvpEmail(),
            rsvp.getRsvpPhone(),
            rsvp.getComments(),
            rsvp.getRsvpId());

        if (saved > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer getRsvpCount() {
        return jdbcTemplate.queryForObject(rsvpCountSQL, Integer.class);
    }
}
