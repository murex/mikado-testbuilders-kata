package com.murex.tbw.purchase;

import com.murex.tbw.domain.country.Country;

import java.util.ArrayList;
import java.util.List;

public final class InvoiceBuilder {
    private String clientName;
    private Country country;
    private int id;
    private List<PurchasedBook> books;

    private InvoiceBuilder() {
        this.books = new ArrayList<>();
    }

    public static InvoiceBuilder newInvoiceBuilder() {
        return new InvoiceBuilder();
    }

    public InvoiceBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public InvoiceBuilder setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public InvoiceBuilder setCountry(Country country) {
        this.country = country;
        return this;
    }

    public InvoiceBuilder addBook(PurchasedBook book) {
        books.add(book);
        return this;
    }

    public Invoice createInvoice() {
        Invoice invoice;
        if (id == 0) {
            invoice = new Invoice(clientName, country);
        } else {
            invoice = new Invoice(id, clientName, country);
        }
        invoice.addPurchasedBooks(books);
        return invoice;
    }
}
