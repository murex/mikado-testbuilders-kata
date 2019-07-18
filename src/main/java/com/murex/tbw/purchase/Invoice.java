package com.murex.tbw.purchase;

import com.murex.tbw.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public final class Invoice {
    private final int id;
    private final String clientName;
    private final List<PurchasedBook> purchasedBooks;

    public Invoice(String clientName) {
        this.id = IdGenerator.nextId();
        this.clientName = clientName;
        this.purchasedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
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
