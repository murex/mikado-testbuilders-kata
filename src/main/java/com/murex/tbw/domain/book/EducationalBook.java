package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

public class EducationalBook implements Book {

    private final String name;
    private final double price;
    private final Author author;
    private final Language language;
    private final Category category;

    public EducationalBook(String name, double price, Author author, Language language, Category category) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.language = language;
        this.category = category;
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

    @Override
    public Language getLanguage() {
        return language;
    }

    public Category getCategory() {
        return category;
    }
}
