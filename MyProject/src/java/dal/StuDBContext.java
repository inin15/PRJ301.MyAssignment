/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dept;
import model.Stu;

/**
 *
 * @author Adim
 */
public class StuDBContext extends DBContext<Stu> {

    public ArrayList<Stu> searchByDid(int did) {
        ArrayList<Stu> stu = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.ename,e.gender,e.dob,d.did,d.dname\n"
                    + "FROM Emp e INNER JOIN Dept d\n"
                    + "ON e.did = d.did\n"
                    + "WHERE d.did = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                Stu e = new Stu();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setDob(rs.getDate("dob"));
                e.setDept(d);
                stu.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StuDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }

    public ArrayList<Stu> filter(Integer id, String name, Boolean gender, Date from, Date to, Integer did) {
        ArrayList<Stu> stu = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.ename,e.gender,e.dob,d.did,d.dname \n"
                    + "FROM Emp e INNER JOIN Dept d ON e.did = d.did\n"
                    + "WHERE (1=1)";
            Integer index = 0;
            HashMap<Integer, Object> params = new HashMap<>();
            if (id != null) {
                index++;
                sql += " AND e.eid = ?";
                params.put(index, id);
            }

            if (name != null) {
                index++;
                sql += " AND e.ename like '%' + ? + '%'";
                params.put(index, name);
            }

            if (gender != null) {
                index++;
                sql += "AND e.gender = ?";
                params.put(index, gender);
            }

            if (from != null) {
                index++;
                sql += " AND e.dob >= ?";
                params.put(index, from);
            }

            if (to != null) {
                index++;
                sql += " AND e.dob <= ?";
                params.put(index, to);
            }

            if (did != null) {
                index++;
                sql += " AND e.did = ?";
                params.put(index, did);
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object> entry : params.entrySet()) {
                Integer key = entry.getKey();
                Object val = entry.getValue();
                stm.setObject(key, val);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                Stu e = new Stu();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setDob(rs.getDate("dob"));
                e.setDept(d);
                stu.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StuDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }

    @Override
    public ArrayList<Stu> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Stu get(int id) {
        try {
            String sql = "SELECT e.eid,e.ename,e.gender,e.dob,d.did,d.dname\n"
                    + "FROM Emp e INNER JOIN Dept d\n"
                    + "ON e.did = d.did\n"
                    + "WHERE e.eid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                Stu e = new Stu();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setDob(rs.getDate("dob"));
                e.setDept(d);
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StuDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Stu model) {
        try {
            String sql = "INSERT INTO [Emp]\n"
                    + "           ([ename]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender]\n"
                    + "           ,[did])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setDate(2, model.getDob());
            stm.setBoolean(3, model.isGender());
            stm.setInt(4, model.getDept().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StuDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Stu model) {
        try {
            String sql = "UPDATE [Emp]\n"
                    + "   SET [ename] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[did] = ?\n"
                    + " WHERE [eid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setDate(2, model.getDob());
            stm.setBoolean(3, model.isGender());
            stm.setInt(4, model.getDept().getId());
            stm.setInt(5, model.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StuDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Stu model) {
        try {
            String sql = "DELETE Emp"
                    + " WHERE [eid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StuDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
