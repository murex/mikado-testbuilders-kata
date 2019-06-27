package com.murex.tbw.domain;

public final class Author {

    private final String name;
    private final String emailAddress;

    public Author(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
