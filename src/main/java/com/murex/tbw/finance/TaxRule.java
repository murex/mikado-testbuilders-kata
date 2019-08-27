package com.murex.tbw.finance;

import com.google.common.collect.ImmutableMap;
import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Language;

import java.util.Map;

public final class TaxRule {

    private static final Map<String, Double> TAX_RATES = ImmutableMap.<String, Double>builder()
            .put("USA", 1.15d)
            .put("France", 1.25d)
            .put("UK", 1.20d)
            .put("Spain", 1.10d)
            .put("China", 1.35d)
            .put("Japan", 1.30d)
            .put("Australia", 1.13d)
            .put("Germany", 1.22d)
            .build();

    public static double getApplicableRate(Country invoiceCountry, Book book) {
        if (invoiceCountry.getName().equals("Germany")) {
            if (book.getAuthor().getNationality().getName().equals("Germany")) {
                return 1.05;
            }
        }
        if (invoiceCountry.getName().equals("USA")) {
            if (book.getClass().equals(Novel.class)) {
                return getTaxRate(invoiceCountry.getName()) * 0.98;
            }
        }
        if (invoiceCountry.getName().equals("UK")) {
            if (book.getClass().equals(Novel.class)) {
                return getTaxRate(invoiceCountry.getName()) * 0.93;
            }
        }
        if (invoiceCountry.getName().equals("China")) {
            if (!book.getLanguage().equals(Language.MANDARIN)) {
                return 1d;
            }
        }
        if (invoiceCountry.getName().equals("Spain")) {
            if (!book.getLanguage().equals(Language.SPANISH)) {
                return 1d;
            }
        }
        return getTaxRate(invoiceCountry.getName());
    }

    private static double getTaxRate(String country) {
        return TAX_RATES.get(country);
    }
}
