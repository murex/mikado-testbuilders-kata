package com.murex.tbw.report;

import com.murex.tbw.domain.Book;
import com.murex.tbw.domain.Country;
import com.murex.tbw.domain.Currency;

public final class PurchasedBook {
    private final Book book;
    private final Country country;

    public PurchasedBook(Book book, Currency currency, Country country) {
        this.book = book;
        this.country = country;
    }

    public Book getBook() {
        return book;
    }

    public Country getCountry() {
        return country;
    }
}
