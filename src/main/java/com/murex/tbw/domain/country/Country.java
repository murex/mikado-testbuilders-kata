package com.murex.tbw.domain.country;

public final class Country {
    private final String name;
    private final Currency currency;
    private final Language language;

    public Country(String name, Currency currency, Language language) {
        this.name = name;
        this.currency = currency;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public Language getLanguage() {
        return language;
    }

    public Currency getCurrency() {
        return currency;
    }
}
