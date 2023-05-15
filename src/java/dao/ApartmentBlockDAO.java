/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApartmentBlock;
import model.Roll;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class ApartmentBlockDAO{

    private DBContext db;
    Roll roll;
    ApartmentBlock Ablock;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    List<ApartmentBlock> listApartment;
    ApartmentBlock dm;

    public ApartmentBlockDAO() {
        listApartment = new ArrayList<>();
        db = new DBContext();
    }

    public ApartmentBlockDAO(List<ApartmentBlock> listApartment) {
        this.listApartment = listApartment;
    }

    public List<ApartmentBlock> getListApartment() {
        return listApartment;
    }

    public void setListApartment(List<ApartmentBlock> listApartment) {
        this.listApartment = listApartment;
    }

    
    public ApartmentBlock details (String id) {
        try {
            String sql = "select * from tb_ApartmentBlock where AblockID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String AblockID = rs.getString("AblockID");
                String AblockName = rs.getString("AblockName");
                Ablock = new ApartmentBlock(AblockID, AblockName);
            }
            return Ablock;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     
    public List<ApartmentBlock> read() {
        listApartment.clear();
        try {
            String sql = "select * from tb_ApartmentBlock";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String apartmentID = rs.getString("AblockID");
                String AblockName = rs.getString("AblockName");
                dm = new ApartmentBlock(apartmentID, AblockName);
                listApartment.add(dm);
            }
            return listApartment;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
