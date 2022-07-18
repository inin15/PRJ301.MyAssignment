


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
    public ArrayList<Students> list(int lessonID) {
        try {
            ArrayList<Students> ds = new ArrayList<>();
            PreparedStatement sql = connection.prepareStatement("select Students.*\n"
                    + "	from Students join GroupStudent on Student.id=GroupStudent.StudentID\n"
                    + "	where GroupStudent.[group] in (\n"
                    + "			select [Group].[group] \n"
                    + "			from [Group] join Couse on [Group].[group]= Couse.[group]\n"
                    + "			where Couse.id = ?\n"
                    + "			)");
            sql.setInt(1, lessonID);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                Students a = new Students(rs.getString("id"),rs.getString("name"));
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
    public boolean insert(Students model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Students model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Students model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
