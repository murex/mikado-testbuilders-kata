package com.murex.tbw.domain.builders;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;

public class CountryTestDataBuilder {
    private String name;
    private Currency currency;
    private Language language;

    public static CountryTestDataBuilder aCountry() {
        return new CountryTestDataBuilder();
    }

    public CountryTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CountryTestDataBuilder withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public CountryTestDataBuilder withLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Country build() {
        return new Country(name, currency, language);
    }
}
