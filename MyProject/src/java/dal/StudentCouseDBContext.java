
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
import model.Students;
import model.StudentCouse;

/**
 *
 * @author Tong Nhat
 */
public class StudentCouseDBContext extends DBContext<StudentCouse> {

    @Override
    public ArrayList<StudentCouse> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<StudentCouse> list(int lessonID) {
        try {
            ArrayList<StudentCouse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("select sl.*,s.name as studentName from StudentCouse sl,Students s\n"
                    + "where s.id = sl.StudentID and sl.LessonID =?");
            sql.setInt(1, lessonID);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                StudentCouse a = new StudentCouse(
                        new Students(rs.getString("StudentID"), rs.getString("studentName")),
                        null, //lesson
                        rs.getBoolean("status"),
                        rs.getString("recordTime"),
                        rs.getString("note")
                );
                ds.add(a);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(StudentCouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StudentCouse get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(StudentCouse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(StudentCouse model) {
        try {
            ArrayList<StudentCouse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("UPDATE StudentCouse\n"
                    + "SET StudentCouse.status = ?, StudentCouse.note = ?, StudentCouse.recordTime = ?\n"
                    + "WHERE StudentCouse.LessonID= ? and StudentCouse.StudentID = ?");
            sql.setBoolean(1, model.isStatus());
            sql.setString(2, model.getNote());
            sql.setString(3, model.getRecordTime());
            sql.setString(4, Integer.toString(model.getCouse().getId()));
            sql.setString(5, model.getStudent().getId());
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentCouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean add(StudentCouse model) {
        try {
            ArrayList<StudentCouse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("INSERT INTO StudentCouse (StudentCouse.LessonID, StudentCouse.StudentID, StudentCouse.status, StudentCouse.note, StudentCouse.recordTime)\n"
                    + "VALUES (?, ?, ?, ?,?)");
            sql.setString(1, Integer.toString(model.getCouse().getId()));
            sql.setString(2, model.getStudent().getId());
            sql.setBoolean(3, model.isStatus());
            sql.setString(4, model.getNote());
            sql.setString(5, model.getRecordTime());
            sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentCouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(StudentCouse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int isExistInTableStudentCouse(String lessonID, String studentID) {
        try {
            ArrayList<StudentCouse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("execute isExistInTableStudentCouse ?,?");
            sql.setString(1, lessonID);
            sql.setString(2, studentID);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                return rs.getInt("dem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentCouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getStatus(Couse thisCouseID) {
         try {
            ArrayList<StudentCouse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("execute getStatus ?");
            sql.setString(1, Integer.toString(thisCouseID.getId()));
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                return rs.getInt("dem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentCouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
