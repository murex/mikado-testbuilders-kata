package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.country.Country;

public final class PurchasedBook {
    private final Book book;
    private final Country country;

    public PurchasedBook(Book book, Country country) {
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
