package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Country;

import java.util.Objects;

public final class Author {

    private final String name;
    private final Country nationality;

    public Author(String name, Country nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }


    public Country getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality=" + nationality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(nationality, author.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality);
    }
}
