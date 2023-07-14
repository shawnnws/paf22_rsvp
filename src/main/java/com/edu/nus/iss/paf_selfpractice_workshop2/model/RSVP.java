package com.edu.nus.iss.paf_selfpractice_workshop2.model;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RSVP {
    
    private int rsvpId;
    private String rsvpName;
    private String rsvpEmail;
    private int rsvpPhone;
    private Date confirmationDate;
    private String comments;

    /**
     * A data class -> is a class that is used to repreesnt the structure of a data, typically JSON / csv
     */

    // public RSVP() {

    // }

    // public RSVP(int rsvpId, String name, String email, int phoneNumber, Date confirmationDate, String comments) {
    //     this.rsvpId = rsvpId;
    //     this.name = name;
    //     this.email = email;
    //     this.phoneNumber = phoneNumber;
    //     this.confirmationDate = confirmationDate;
    //     this.comments = comments;
    // }
    
    // public static RSVP fromMap(Map<String, Object> mapObject) {
        /**
         * A helper method that takes in a Map<String, Object> from JDBCTemplate.queryList()
         * to create a RSVP object
         * 
         * We will getting all 6 columns from the Map
         * And call the constructor to get the RSVP object
         * 
         * PS: Be extra careful when casting a parent type to a child type
         * it can kaboom if we e.g try to cast an Animal to a Cat, when its really a Dog
         * 
         */

        /**
         * Step 1: get all 6 values necessary for the RSVP Constructor from the Map
         * 
         * Q: Why are we all using reference types instead of primitives here (e.g Integer instead of int)
         * A: The mapObject contains god type Object 
         * We can only cast Object into a Reference Type, not a primitive
         * 
         * We will rely on Java's auto-unboxing to unbox the Reference Types to int
         */
    //     Integer objectRsvpId = (Integer) mapObject.get("rsvpId");
    //     String objectName = (String) mapObject.get("name");
    //     String objectEmail = (String) mapObject.get("email");
    //     Integer objectPhoneNumber = (Integer) mapObject.get("phoneNumber");
    //     Date objectConfirmationDate = (Date) mapObject.get("confirmationDate");
    //     String objectComments = (String) mapObject.get("comments");
        
    //     return new RSVP(objectRsvpId, objectName, objectEmail, objectPhoneNumber, objectConfirmationDate, objectComments);
    // }

    // public int getRsvpId() {
    //     return rsvpId;
    // }

    // public void setRsvpId(int rsvpId) {
    //     this.rsvpId = rsvpId;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public int getPhoneNumber() {
    //     return phoneNumber;
    // }

    // public void setPhoneNumber(int phoneNumber) {
    //     this.phoneNumber = phoneNumber;
    // }

    // public Date getConfirmationDate() {
    //     return confirmationDate;
    // }

    // public void setConfirmationDate(Date confirmationDate) {
    //     this.confirmationDate = confirmationDate;
    // }

    // public String getComments() {
    //     return comments;
    // }

    // public void setComments(String comments) {
    //     this.comments = comments;
    // }

    

}
