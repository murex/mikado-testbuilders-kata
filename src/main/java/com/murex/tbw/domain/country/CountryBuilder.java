package com.murex.tbw.domain.country;

public final class CountryBuilder {
    private String name;
    private Currency currency;
    private Language language;

    private CountryBuilder() {
    }

    public static CountryBuilder newCountryBuilder() {
        return new CountryBuilder();
    }

    public CountryBuilder setCountryName(String name) {
        this.name = name;
        return this;
    }

    public CountryBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public CountryBuilder setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Country createCountry() {
        return new Country(name, currency, language);
    }
}
