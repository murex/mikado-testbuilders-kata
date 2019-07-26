package com.murex.tbw.finance;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Language;

public class TaxRule {

    public double computePriceAfterTax(Country invoiceCountry, Book book) {
        if (invoiceCountry.getName().equals("Germany")) {
            return book.getPrice() * 1.05;
        }
        if (invoiceCountry.getName().equals("USA")) {
            return book.getPrice() * FinanceConstants.getTaxRate(invoiceCountry.getName()) * 0.98;
        }
        if (invoiceCountry.getName().equals("UK")) {
            return book.getPrice() * FinanceConstants.getTaxRate(invoiceCountry.getName()) * 0.93;
        }
        if (invoiceCountry.getName().equals("China")) {
            if (!book.getLanguage().equals(Language.MANDARIN)) {
                return book.getPrice();
            }
        }
        if (invoiceCountry.getName().equals("Spain")) {
            if (!book.getLanguage().equals(Language.SPANISH)) {
                return book.getPrice();
            }
        }
        return book.getPrice() * FinanceConstants.getTaxRate(invoiceCountry.getName());
    }
}
