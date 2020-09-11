/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.messages_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class DatabaseConnection {
    public Connection getConnection() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app", "juan", "admin");
            if (connection != null)
                System.out.println("Successful connection!");
        } catch (SQLException e) {
            
        }
        
        return connection;
    }
}
