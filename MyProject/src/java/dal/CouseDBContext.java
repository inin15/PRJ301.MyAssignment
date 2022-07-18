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
import model.Group;
import model.Instructor;
import model.Subject;

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
                a.setName(rs.getString("name"));
                //a.setCourse(rs.getString("course"));
                //a.setInstructor(rs.getString("instructor"));
                a.setRoom(rs.getString("room"));
                a.setNumberOfWeek(rs.getInt("numberOfWeek"));
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
            PreparedStatement sql = connection.prepareStatement("select *\n" + "from [Couse] where slot = ? and numberOfWeek= ?");
            sql.setInt(1, slot);
            sql.setInt(2, numberOfWeek);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                Couse a = new Couse();
                a.setSlot(slot);
                a.setId(rs.getInt("id"));
                a.setDate(rs.getDate("date"));
                a.setGroup(rs.getString("group"));
                a.setName(rs.getString("name"));
                //a.setCourse(rs.getString("course"));
                //a.setInstructor(rs.getString("instructor"));
                a.setRoom(rs.getString("room"));
                a.setNumberOfWeek(rs.getInt("numberOfWeek"));
                ds.add(a);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Couse> listAllCouseInThisWeekAndLecture(int numberOfWeek, String lecture) {
        try {
            ArrayList<Couse> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("SELECT *\n"
                    + "FROM\n"
                    + "(\n"
                    + "	select [group], GroupInstructor.InstructorID as instructorID , GroupInstructor.CourseID as courseID, Course.name as courseName, GroupInstructor.name as instructorName  \n"
                    + "	from \n"
                    + "	(select * from [Group] join Instructor on Instructor.id = [Group].InstructorID  where Instructor.name like ?) GroupInstructor \n"
                    + "	join Course on Course.id= GroupInstructor.CourseID\n"
                    + ") group1,\n"
                    + "(select * from Couse where Couse.numberOfWeek = ?) lesson1\n"
                    + "WHERE group1.[group] = lesson1.[group]");
            sql.setString(1, "%"+lecture+"%");
            sql.setInt(2, numberOfWeek);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                Couse a = new Couse();
                a.setId(rs.getInt("id"));
                a.setGroup(new Group(rs.getString("group"),
                                    new Subject(rs.getString("courseID"),rs.getString("courseName")),
                                    new Instructor(rs.getString("instructorID"),rs.getString("instructorName"))
                                    )
                            );
                a.setName(rs.getString("name"));
                a.setSlot(rs.getInt("slot"));
                a.setRoom(rs.getString("room"));
                a.setDate(rs.getDate("date"));
                a.setNumberOfWeek(rs.getInt("numberOfWeek"));
                //a.setCourse(rs.getString("course"));
                //a.setInstructor(rs.getString("instructor"));\
                ds.add(a);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Couse get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Couse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Couse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Couse model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Couse> list(int did) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

}
