package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Country;

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
}
