/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MessagesApp.dao;

import com.mycompany.MessagesApp.model.Message;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class MessageDAO {

    public static void addMessage(Message message) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                String query = "INSERT INTO messages(contents, author, date) VALUES(?, ?, NOW());";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, message.getContents());
                ps.setString(2, message.getAuthor());
                ps.executeUpdate();

                System.out.println("CREATED!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Message> getAllMessages() {
        ArrayList<Message> messages = new ArrayList<>();
        
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM messages;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            
            StringBuilder sb = new StringBuilder();
            
            while(result.next()) {
                int id = result.getInt("id");
                String contents = result.getString("contents");
                String author = result.getString("author");
                Timestamp date = result.getTimestamp("date");
                
                messages.add(new Message(id, contents, author, date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return messages;
    }

    public static void updateMessage(Message message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}