/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MessagesApp;

import com.mycompany.MessagesApp.dao.DatabaseConnection;
import com.mycompany.MessagesApp.service.MessageService;
import java.util.Scanner;

/**
 *
 * @author juan
 */
public class Main {
    
    public static void main(String[] args) {
        DatabaseConnection dbc = new DatabaseConnection();
        MessageService service = new MessageService();
               
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("----------------------------------");
            System.out.println("Select an option:");
            System.out.println("1- Create a message");
            System.out.println("2- List all messages");
            System.out.println("3- Update a message");
            System.out.println("4- Delete a message");
            System.out.println("5- Exit");
            System.out.println("----------------------------------");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    service.createMessage();
                    break;
                case 2:
                    service.getAllMessages();
                    break;
                case 3:
                    service.updateMessage();
                    break;
                case 4:
                    service.deleteMessage();
                    break;
                case 5:
                    System.out.println("\nBye !");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while(option != 5);
            
    }
    
}
