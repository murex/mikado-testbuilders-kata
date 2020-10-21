/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Novel{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author=" + author +
                ", language=" + language +
                ", genres=" + genres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return Double.compare(novel.price, price) == 0 &&
                Objects.equals(name, novel.name) &&
                Objects.equals(author, novel.author) &&
                language == novel.language &&
                Objects.equals(genres, novel.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, author, language, genres);
    }
}
