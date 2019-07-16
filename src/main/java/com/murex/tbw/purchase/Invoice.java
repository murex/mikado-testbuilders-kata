package com.murex.tbw.purchase;

import java.util.ArrayList;
import java.util.List;

public final class Invoice {
    private final int id;
    private final List<PurchasedBook> purchasedBooks;

    public Invoice() {
        this.id = 1;
        this.purchasedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addPurchasedBook(PurchasedBook book) {
        this.purchasedBooks.add(book);
    }

    public double computerTotalPrice() {
        return purchasedBooks.stream().mapToDouble(PurchasedBook::getTotalPrice).sum();
    }

    public List<PurchasedBook> getPurchasedBooks() {
        return purchasedBooks;
    }
}
