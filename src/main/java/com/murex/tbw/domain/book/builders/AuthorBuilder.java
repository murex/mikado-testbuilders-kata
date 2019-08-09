package com.murex.tbw.domain.book.builders;

import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.country.Country;

public final class AuthorBuilder {

    private String name;
    private String emailAddress;
    private Country nationality;

    private AuthorBuilder() {

    }

    public static AuthorBuilder newAuthorBuilder() {
        return new AuthorBuilder();
    }

    public AuthorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public AuthorBuilder setNationality(Country nationality) {
        this.nationality = nationality;
        return this;
    }

    public Author createAuthor() {
        return new Author(name, nationality);
    }
}
