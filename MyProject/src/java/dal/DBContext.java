/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Ngo Tung Son
 */
public abstract class DBContext<T> {
    protected Connection connection;
    public DBContext()
    {
        try {
            String user = "sa";
            String pass = "12345678";
            String url = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;databaseName=Assingment";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public abstract ArrayList<T> list(int did);
    public abstract ArrayList<T> list();
    public abstract T get(int id);
    public abstract void insert(T model);
    public abstract void update(T model);
    public abstract void delete(T model);
   
}
    