package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

import java.util.List;

public final class Novel implements Book {

    private final String name;
    private final double price;
    private final Author author;
    private final Language language;
    private final List<Genre> genres;

    public Novel(String name, double price, Author author, Language language, List<Genre> genres) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.language = language;
        this.genres = genres;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }
}
