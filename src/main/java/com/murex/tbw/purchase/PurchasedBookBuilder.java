package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Book;

public final class PurchasedBookBuilder {

    private Book book;
    private int quantity;

    private PurchasedBookBuilder() {
    }

    public static PurchasedBookBuilder newPurchasedBookBuilder() {
        return new PurchasedBookBuilder();
    }

    public PurchasedBookBuilder setBook(Book book) {
        this.book = book;
        return this;
    }

    public PurchasedBookBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PurchasedBook createPurchasedBook() {
        return new PurchasedBook(book, quantity);
    }
}
