package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.TestCountries;

public class AuthorTestDataBuilder {
    private String name = "John Steinbeck";

    public AuthorTestDataBuilder anAuthor() {
        return new AuthorTestDataBuilder();
    }

    public AuthorTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Author build() {
        return new Author(name, TestCountries.USA);
    }
}
