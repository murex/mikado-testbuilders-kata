/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.domain.country;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                ", language=" + language +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                currency == country.currency &&
                language == country.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currency, language);
    }
}
