


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
import model.Students;

/**
 *
 * @author Adim
 */
public class StuDBContext extends DBContext<Students> {

    @Override
    public ArrayList<Students> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public ArrayList<Students> list(int couseID) {
        try {
            ArrayList<Students> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("select Students.*\n"
                    + "	from Students join GroupStudent on Student.id=GroupStudent.id\n"
                    + "	where GroupStudent.[group] in (select [Group].[group] \n"
                    + "	from [Group] join Lesson on [Group].[group]= Lesson.[group]\n"
                    + "	where Lesson.id = ?)");
            sql.setInt(1, couseID);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                Students a = new Students();
                a.setId(rs.getString("id"));
                a.setName(rs.getString("name"));
                ds.add(a);
            }
            System.out.println("----------------" + ds.size());
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CouseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Students get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Students model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Students model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Students model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
   
}
