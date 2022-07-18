/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Couse;

/**
 *
 * @author Admin
 */
public class CouseDBContext extends DBContext<Couse> {

    @Override
    public ArrayList<Couse> list() {
        try {
            ArrayList<Couse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("select * from [Couse]");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                Couse a = new Couse();
                a.setId(rs.getInt("id"));
                a.setSlot(rs.getInt("slot"));
                a.setDate(rs.getDate("date"));
                a.setGroup(rs.getString("group"));
                a.setCourse(rs.getString("course"));
                a.setInstructor(rs.getString("instructor"));
                a.setRoom(rs.getString("room"));
                ds.add(a);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Couse> list(int did, int numberOfWeek) {
        int slot = did;
        try {
            ArrayList<Couse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("select *\n" + "from [Couse] where slot = ? and numverOfWeek= ?");
            sql.setInt(1, slot);
            sql.setInt(2, numberOfWeek);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                Couse a = new Couse();
                a.setSlot(slot);
                a.setId(rs.getInt("id"));
                a.setDate(rs.getDate("date"));
                a.setGroup(rs.getString("group"));
                a.setCourse(rs.getString("course"));
                a.setInstructor(rs.getString("instructor"));
                a.setRoom(rs.getString("room"));
                a.setNumberOfWeek(numberOfWeek);
                ds.add(a);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Couse> list(int did) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Couse get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Couse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Couse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Couse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

}
