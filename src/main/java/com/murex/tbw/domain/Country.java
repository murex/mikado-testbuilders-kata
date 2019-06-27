package com.murex.tbw.domain;

public final class Country {
    private final String name;
    private final Currency currency;
    private final Language officialLanguage;

    public Country(String name, Currency officialCurrency, Language officialLanguage) {
        this.name = name;
        this.currency = officialCurrency;
        this.officialLanguage = officialLanguage;
    }
}
