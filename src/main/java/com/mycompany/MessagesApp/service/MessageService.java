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
    
    public void updateMessage() {
        
    }
    
    public void deleteMessage() {
        
    }
}
