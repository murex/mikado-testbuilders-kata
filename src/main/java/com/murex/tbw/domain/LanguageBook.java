package com.murex.tbw.domain;

public class LanguageBook implements Book {

    private final String name;
    private final double price;
    private final Author author;
    private final Language language;

    public LanguageBook(String name, double price, Author author, Language language) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.language = language;
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

    public Language getLanguage() {
        return language;
    }
}
