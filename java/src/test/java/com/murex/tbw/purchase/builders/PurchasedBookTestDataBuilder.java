package com.murex.tbw.purchase.builders;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.purchase.PurchasedBook;

public class PurchasedBookTestDataBuilder {
    private Book book;
    private int quantity;

    public static PurchasedBookTestDataBuilder aPurchasedBook() {
        return new PurchasedBookTestDataBuilder();
    }

    public PurchasedBookTestDataBuilder withBook(Book book) {
        this.book = book;
        return this;
    }

    public PurchasedBookTestDataBuilder ofQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PurchasedBook build() {
        return new PurchasedBook(book, quantity);
    }
}
