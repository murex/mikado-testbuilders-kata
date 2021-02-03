package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Book;

public class PurchasedBookTestDataBuilder {
    private Book book;
    private int quantity = 1;

    public static PurchasedBookTestDataBuilder aPurchasedBook() {
        return new PurchasedBookTestDataBuilder();
    }

    public PurchasedBookTestDataBuilder withBook(Book book) {
        this.book = book;
        return this;
    }

    public PurchasedBookTestDataBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PurchasedBook build() {
        return new PurchasedBook(book, quantity);
    }
}
