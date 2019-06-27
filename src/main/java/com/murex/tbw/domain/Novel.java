package com.murex.tbw.domain;

public class Novel implements Book {

    private final String name;
    private final double price;
    private final Author author;

    public Novel(String name, double price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Author getAuthor() {
        return author;
    }


}
