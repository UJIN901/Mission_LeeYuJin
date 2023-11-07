package com.ll.domain;

import lombok.Getter;
import lombok.Setter;

public class Quotation {
    @Getter
    public int id;
    @Getter
    @Setter
    public String text;
    @Getter
    @Setter
    public String author;

    public Quotation(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }
}


