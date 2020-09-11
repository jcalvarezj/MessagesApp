/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.messages_app;

import java.sql.Connection;

/**
 *
 * @author juan
 */
public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbc = new DatabaseConnection();
        
        try (Connection conn = dbc.getConnection()) {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
