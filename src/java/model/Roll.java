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
public class Roll {
    private String rollID;
    private String rollName;

    public Roll() {
    }

    public Roll(String rollID, String rollName) {
        this.rollID = rollID;
        this.rollName = rollName;
    }

    public String getRollID() {
        return rollID;
    }

    public void setRollID(String rollID) {
        this.rollID = rollID;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }
    
}
