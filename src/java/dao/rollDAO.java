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
import model.Employee;
import model.Roll;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class rollDAO {
    
    private DBContext db;
    Roll roll;
    
     public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    List<Roll> listItems;
    Roll dm;

    public rollDAO() {
        listItems = new ArrayList<>();
        db = new DBContext();
    }

      public rollDAO(List<Roll> listItems) {
        this.listItems = listItems;
    }

    public List<Roll> getListItems() {
        return listItems;
    }

    public void setListItems(List<Roll> listItems) {
        this.listItems = listItems;
    }
    
    public Roll details(String id) {
        try {
            String sql = "select * from tb_Roll where rollID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String rollID = rs.getString("rollID");
                String rollName = rs.getString("rollName");

                roll = new Roll(rollID, rollName);
            }
            return roll;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public List<Roll> read() {
     listItems.clear();
        try {
             String sql = "select * from tb_Roll";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String rollID = rs.getString("rollID");
                String rollName = rs.getString("rollName");

                roll = new Roll(rollID, rollName);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(rollDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
