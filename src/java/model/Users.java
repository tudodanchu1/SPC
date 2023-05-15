/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TADAR
 */
public class Users {
    private String userID;
    private String email;
    private int phoneNumber;
    private String fullName;
    private String pass;
    private Roll rollID;


    public Users() {
    }

    public Users(String userID, String email, int phoneNumber, String fullName, String pass) {
        this.userID = userID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.pass = pass;
    }
    

    public Users(String userID, String email, int phoneNumber, String fullName, String pass, Roll rollID) {
        this.userID = userID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.pass = pass;
        this.rollID = rollID;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Roll getRollID() {
        return rollID;
    }

    public void setRollID(Roll rollID) {
        this.rollID = rollID;
    }


    
}
