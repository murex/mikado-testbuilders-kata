package com.murex.tbw.finance;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Language;

import static com.murex.tbw.finance.FinanceConstants.getTaxRate;

public class TaxRule {

    public static double getApplicableTax(Country invoiceCountry, Book book) {
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
}
