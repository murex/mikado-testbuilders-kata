package com.murex.tbw.domain.book.builders;

import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.book.Category;
import com.murex.tbw.domain.book.EducationalBook;
import com.murex.tbw.domain.country.Language;

public final class EducationalBookBuilder {
    private String name;
    private double price;
    private Author author;
    private Language language;
    private Category category;

    private EducationalBookBuilder() {
    }

    public static EducationalBookBuilder newEducationalBookBuilder() {
        return new EducationalBookBuilder();
    }

    public EducationalBookBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EducationalBookBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public EducationalBookBuilder setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public EducationalBookBuilder setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public EducationalBookBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    public EducationalBook createEducationalBook() {
        return new EducationalBook(name, price, author, language, category);
    }
}
