package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.book.Genre;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.country.Language;

import java.util.ArrayList;
import java.util.List;

public class NovelTestDataBuilder {

    private String name = "NO_NAME";
    private double price = 0.0;
    private Author author = null;
    private Language language = Language.ENGLISH;
    private List<Genre> genreList = new ArrayList();


    public static NovelTestDataBuilder aNovel() {
        return new NovelTestDataBuilder();
    }

    public NovelTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public NovelTestDataBuilder priced(double price) {
        this.price = price;
        return this;
    }

    public Novel build() {
        return  new Novel(name, price, author, language, genreList);
    }
}
