/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class adminDAO {
    
    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    Admin admin;

    public adminDAO() {
        db = new DBContext();
    }
    
    public Admin checkTenTaiKhoan(String tentaikhoan) {
        admin = null;
        try {
            String sql = "select * from tb_admin where ademail=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, tentaikhoan);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tentaikhoan = rs.getString("ademail");
                String _matkhau = rs.getString("adpassword");
                
                admin = new Admin(_tentaikhoan, _matkhau);
            }
            return admin;
        } catch (SQLException e) {
            Logger.getLogger(adminDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public Admin check(String tentaikhoan, String matkhau) {
        admin = null;
        try {
            String sql = "select * from tb_admin where adminID=? and adpassword=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, tentaikhoan);
            stmt.setString(2, matkhau);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tentaikhoan = rs.getString("adminID");
                String _matkhau = rs.getString("adpassword");
                

                admin = new Admin(_tentaikhoan, _matkhau);
            }
            return admin;
        } catch (SQLException e) {
            Logger.getLogger(adminDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
