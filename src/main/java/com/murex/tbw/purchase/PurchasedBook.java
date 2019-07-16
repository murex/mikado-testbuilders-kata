package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Book;

import java.util.Objects;

public final class PurchasedBook {
    private final Book book;
    private final int quantity;

    public PurchasedBook(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return book.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "PurchasedBook{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedBook that = (PurchasedBook) o;
        return quantity == that.quantity &&
                Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, quantity);
    }
}
