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
public class Employee {
    private String email;
    private String fullName;
    private String password;
    private ApartmentBlock AblockID;
    private Roll rollID ;

    public Employee() {
    }

    public Employee(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public Employee(String email, String fullName, String password, ApartmentBlock AblockID) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.AblockID = AblockID;
    }
    

    public Employee(String email, String fullName, String password, ApartmentBlock AblockID, Roll rollID) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.AblockID = AblockID;
        this.rollID = rollID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ApartmentBlock getAblockID() {
        return AblockID;
    }

    public void setAblockID(ApartmentBlock AblockID) {
        this.AblockID = AblockID;
    }

    public Roll getRollID() {
        return rollID;
    }

    public void setRollID(Roll rollID) {
        this.rollID = rollID;
    }
    
    

}
