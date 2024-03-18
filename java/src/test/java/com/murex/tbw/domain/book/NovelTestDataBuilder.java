package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

import java.util.Collections;

public class NovelTestDataBuilder {
    private String name = "The Grapes of Wrath";
    private double price = 15.0;
    private Author author = new AuthorTestDataBuilder().build();
    private Language language = Language.ENGLISH;

    public static NovelTestDataBuilder aNovel() {
        return new NovelTestDataBuilder();
    }

    public NovelTestDataBuilder titled(String name) {
        this.name = name;
        return this;
    }

    public NovelTestDataBuilder costing(double price) {
        this.price = price;
        return this;
    }

    public NovelTestDataBuilder by(Author author) {
        this.author = author;
        return this;
    }

    public NovelTestDataBuilder writtenIn(Language language) {
        this.language = language;
        return this;
    }

    public Novel build() {
        return new Novel(name, price, author, language, Collections.emptyList());
    }
}
