/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MessagesApp.service;

import com.mycompany.MessagesApp.dao.MessageDAO;
import com.mycompany.MessagesApp.model.Message;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juan
 */
public class MessageService {

    public void createMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your message: ");
        String content = scanner.nextLine();
        
        System.out.println("Now write your name: ");
        String author = scanner.nextLine();
        
        Message message = new Message();
        message.setContents(content);
        message.setAuthor(author);
        
        MessageDAO.addMessage(message);
    }
    
    public void getAllMessages() {
        ArrayList<Message> result = MessageDAO.getAllMessages();
        
        StringBuilder sb = new StringBuilder();
        
        for (Message message : result) {
            sb.append("ID: ").append(message.getId());
            sb.append("\nContents: ").append(message.getContents());
            sb.append("\nAuthor: ").append(message.getAuthor());
            sb.append("\nDate: ").append(message.getDate());

            System.out.println(sb);

            sb = new StringBuilder();
        }
    }
    
    public Message getMessageById(int id) {
        Message result = MessageDAO.getMessageById(id);        
        return result;
    }
    
    public void updateMessage() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please type the id of the message to modify: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            
            Message oldMessage = getMessageById(id);
            
            if (oldMessage == null)
                System.out.println("Sorry, no message for the specified id exists");
            else {
                System.out.println("Modifying " + oldMessage);
                System.out.println("Please enter the new contents:");
                String contents = scanner.nextLine();
                System.out.println("Please enter the new author:");
                String author = scanner.nextLine();
                
                Message newMessage = new Message();
                newMessage.setContents(contents);
                newMessage.setAuthor(author);
                newMessage.setId(id);
                
                if (MessageDAO.updateMessage(newMessage))
                    System.out.println("Successful update!");
                else
                    System.out.println("Could not update");
            }
        } catch (NumberFormatException e) {
            System.out.println("Sorry, only numbers accepted");
        }
    }
    
    public void deleteMessage() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please type the id of the message to delete: ");
        int id = scanner.nextInt();
        
        if (MessageDAO.deleteMessage(id))
            System.out.println("The record was deleted!");
        else
            System.out.println("The record was not found.");
    }
}
