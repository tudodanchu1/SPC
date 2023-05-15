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
public class ApartmentBlock {
    private  String AblockID;
    private String AblockName;

    public ApartmentBlock() {
    }

    
    public ApartmentBlock(String AblockID, String AblockName) {
        this.AblockID = AblockID;
        this.AblockName = AblockName;
    }

    public String getAblockID() {
        return AblockID;
    }

    public void setAblockID(String AblockID) {
        this.AblockID = AblockID;
    }

    public String getAblockName() {
        return AblockName;
    }

    public void setAblockName(String AblockName) {
        this.AblockName = AblockName;
    }
    
}
