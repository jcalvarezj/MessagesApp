/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MessagesApp.dao;

import com.mycompany.MessagesApp.model.Message;
import java.sql.Connection;
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
                String sqlStatement = "INSERT INTO messages(contents, author, date) VALUES(?, ?, NOW());";

                PreparedStatement ps = connection.prepareStatement(sqlStatement);
                ps.setString(1, message.getContents());
                ps.setString(2, message.getAuthor());
                ps.executeUpdate();

                System.out.println("CREATED!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static Message getMessageById(int id) {
        Message message = null;
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM messages WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);            
            ResultSet result = ps.executeQuery();
            
            if (result.isBeforeFirst()) {
                result.next();

                int rId = result.getInt("id");
                String contents = result.getString("contents");
                String author = result.getString("author");
                Timestamp date = result.getTimestamp("date");
                
                message = new Message(rId, contents, author, date);
            }                        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return message;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return messages;
    }

    public static boolean updateMessage(Message message) {
        int updatedRows = -1;
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sqlStatement = "UPDATE messages SET contents = ?, author = ? WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setString(1, message.getContents());
            ps.setString(2, message.getAuthor());
            ps.setInt(3, message.getId());
            
            updatedRows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return updatedRows > 0;
    }
    
    public static boolean deleteMessage(int id) {
        int updatedRows = -1;
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sqlStatement = "DELETE FROM messages WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setInt(1, id);
            
            updatedRows = ps.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return updatedRows > 0;
    }
    
}