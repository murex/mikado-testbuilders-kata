package com.murex.tbw.domain.builders;

import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.country.Country;

import java.util.Date;

public class AuthorTestDataBuilder {
    private String name;
    private Country country;

    public static AuthorTestDataBuilder anAuthor() {
        return new AuthorTestDataBuilder();
    }

    public AuthorTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AuthorTestDataBuilder from(Country country) {
        this.country = country;
        return this;
    }

    public Author build() {
        return new Author(name, country);
    }
}
