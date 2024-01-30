/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.utility;


import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rkhjp
 */
public class ConnectionPool {
    static Connection conn;
    
    public static Connection connectDB() throws ClassNotFoundException, SQLException{
        //step1

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/PersonalInventorySystem","root","123456789");
        System.out.println("Database Connected Succes");
        return conn;
        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        connectDB();
    }
}
