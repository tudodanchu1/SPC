/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author TADAR
 */
public class Car {
    private String carID;
    private String carName;
    private String carPlate;
    private Users userID;

    public Car() {
    }

    public Car(String carID, String carName, String carPlate) {
        this.carID = carID;
        this.carName = carName;
        this.carPlate = carPlate;
    }
    
       public Car(String carID, String carName, String carPlate, Users userID) {
        this.carID = carID;
        this.carName = carName;
        this.carPlate = carPlate;
        this.userID = userID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

 


    
}
