/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author TADAR
 */
import java.sql.Date;
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
import model.Roll;
import model.Users;
import util.DBContext;

public class userDAO implements ICrud<String, Users> {
    private DBContext db;
    rollDAO roll;

    private List<Users> listItems;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    public rollDAO getrollDao() {
        return roll;
    }

    public void setrollDao(rollDAO roll) {
        this.roll = roll;
    }

    Users dm;

    public userDAO() {
        listItems = new ArrayList<>();
        db = new DBContext();
        roll = new rollDAO();
    }


      public userDAO(List<Users> listItems) {
        this.listItems = listItems;
    }

    public List<Users> getListItems() {
        return listItems;
    }

    public void setListItems(List<Users> listItems) {
        this.listItems = listItems;
    }


    @Override
    public List<Users> read() {
     listItems.clear();
        try {
            String sql = "select * from tb_Users";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                int phoneNo = rs.getInt("phoneNumber");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("pass");
                Roll rollID = roll.details(rs.getString("rollID"));
               
                dm = new Users(useID, email, phoneNo, fullname, pass, rollID);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Users details(String userID) {
       try {
            String sql = "select * from tb_Users where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                int phoneNo = rs.getInt("phoneNumber");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("pass");
                Roll rollID = roll.details(rs.getString("rollID"));
               
                dm = new Users(useID, email, phoneNo, fullname, pass, rollID);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public void create(Users newUser) {
         try {
            String sql = "insert into tb_Users(userID, email, phoneNumber, fullname, pass, rollID) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newUser.getUserID());
            stmt.setString(2, newUser.getEmail());
            stmt.setInt(3, newUser.getPhoneNumber());
            stmt.setString(4, newUser.getFullName());
            stmt.setString(5, newUser.getPass());
            stmt.setString(6, "US");
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Users edittedUser) {
        try {
            String sql = "update tb_Users set email=?, phoneNumber=?, fullname=?, pass=? where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(5, edittedUser.getUserID());
            stmt.setString(1, edittedUser.getEmail());
            stmt.setInt(2, edittedUser.getPhoneNumber());
            stmt.setString(3, edittedUser.getFullName());
            stmt.setString(4, edittedUser.getPass());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql2 = "update tb_Car set userID=NULL where userID=?";
            String sql = "delete tb_Users where userID=?";
            PreparedStatement stmt2 = db.getConn().prepareStatement(sql2);   
            PreparedStatement stmt = db.getConn().prepareStatement(sql); 
            stmt2.setString(1, id);
            stmt2.executeUpdate();
            stmt.setString(1,id);
            stmt.executeUpdate();   
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
   
}