package com.ll;

public class Quotation {
    int id;
    String text;
    String author;

    Quotation(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
