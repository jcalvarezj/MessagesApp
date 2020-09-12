/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MessagesApp.model;

import java.sql.Timestamp;

/**
 *
 * @author juan
 */
public class Message {
    private int id;
    private String contents, author;
    private Timestamp date;

    public Message() {
    }

    public Message(int id, String contents, String author, Timestamp date) {
        this.id = id;
        this.contents = contents;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
}
