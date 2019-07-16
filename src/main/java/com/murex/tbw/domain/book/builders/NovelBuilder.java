package com.murex.tbw.domain.book.builders;

import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.book.Genre;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.country.Language;

import java.util.ArrayList;
import java.util.List;

public final class NovelBuilder {
    private String name;
    private double price;
    private Author author;
    private Language language;
    private List<Genre> genres;

    private NovelBuilder() {
        genres = new ArrayList<>();
    }

    public static NovelBuilder newNovelBuilder() {
        return new NovelBuilder();
    }

    public NovelBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public NovelBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public NovelBuilder setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public NovelBuilder setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public NovelBuilder setGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public NovelBuilder addGenre(Genre genre) {
        this.genres.add(genre);
        return this;
    }

    public NovelBuilder addGenres(List<Genre> genre) {
        this.genres.addAll(genre);
        return this;
    }

    public Novel createNovel() {
        return new Novel(name, price, author, language, genres);
    }
}
