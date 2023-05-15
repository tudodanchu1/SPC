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
public class Spot {
    private String spotID;
    private boolean available;
    private String sensorID;
    private ApartmentBlock AblockID;

    public Spot() {
    }

    public Spot(String spotID, boolean available, String sensorID) {
        this.spotID = spotID;
        this.available = available;
        this.sensorID = sensorID;
    }

    public Spot(String spotID, boolean available, String sensorID, ApartmentBlock AblockID) {
        this.spotID = spotID;
        this.available = available;
        this.sensorID = sensorID;
        this.AblockID = AblockID;
    }

    public String getSpotID() {
        return spotID;
    }

    public void setSpotID(String spotID) {
        this.spotID = spotID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public ApartmentBlock getAblockID() {
        return AblockID;
    }

    public void setAblockID(ApartmentBlock AblockID) {
        this.AblockID = AblockID;
    }
    
    
    
}
