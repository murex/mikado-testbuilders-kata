package com.murex.tbw.purchase;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;

import static com.murex.tbw.domain.country.Currency.US_DOLLAR;
import static com.murex.tbw.domain.country.Language.ENGLISH;

public class CountryTestDataBuilder {
    private String name;
    private Currency currency = US_DOLLAR;
    private Language language = ENGLISH;

    public static CountryTestDataBuilder aCountry() {
        return new CountryTestDataBuilder();
    }

    public CountryTestDataBuilder named(String name) {
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
