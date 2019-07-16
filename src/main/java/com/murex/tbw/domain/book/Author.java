package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Country;

import java.util.Objects;

public final class Author {

    private final String name;
    private final String emailAddress;
    private final Country nationality;

    public Author(String name, String emailAddress, Country nationality) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Country getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", nationality=" + nationality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(emailAddress, author.emailAddress) &&
                Objects.equals(nationality, author.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAddress, nationality);
    }
}
