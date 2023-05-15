/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApartmentBlock;
import model.Car;
import model.Employee;
import model.Spot;
import model.Roll;
import model.Spot;
import model.Users;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public abstract class spotDAO implements ICrud<String, Spot>{

    
    private DBContext db;
    ApartmentBlockDAO Ablock;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    List<Spot> listSpot;
    Spot dm;

    public spotDAO() {
        listSpot = new ArrayList<>();
        db = new DBContext();
    }

    public spotDAO(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }

    public List<Spot> getListSpot() {
        return listSpot;
    }

    public void setListSpot(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }
    
    @Override
    public List<Spot> read() {
       listSpot.clear();
        try {
            String sql = "select * from tb_Spot";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotID = rs.getString("spotID");
                boolean available = rs.getBoolean("available");
                String sensorID = rs.getString("sensorID");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
               
               
                dm = new Spot(spotID, available, sensorID, AblockID);
                listSpot.add(dm);
            }
            return listSpot;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Spot details(String spotId) {
         try {
            String sql = "select * from tb_Spot where spotID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, spotId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotID = rs.getString("spotID");
                boolean available = rs.getBoolean("available");
                String sensorID = rs.getString("sensorID");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
               
               dm = new Spot(spotID, available, sensorID, AblockID);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public void update(Spot edittedSpot) {
        try {
            String sql = "update tb_Spot(spotID, available, sensorID, AbockID) where spotID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedSpot.getSpotID());
            stmt.setBoolean(2, edittedSpot.isAvailable());
            stmt.setString(3,edittedSpot.getSensorID());
            stmt.setString(4, edittedSpot.getAblockID().getAblockID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
}
