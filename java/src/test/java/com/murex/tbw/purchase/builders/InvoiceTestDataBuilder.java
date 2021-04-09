package com.murex.tbw.purchase.builders;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;

import java.util.ArrayList;
import java.util.List;

public class InvoiceTestDataBuilder {

    private String clientName;
    private Country country;
    private List<PurchasedBook> purchasedBooks = new ArrayList<>();

    public static InvoiceTestDataBuilder anInvoice() {
        return new InvoiceTestDataBuilder();
    }

    public InvoiceTestDataBuilder forClient(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public InvoiceTestDataBuilder in(Country country) {
        this.country = country;
        return this;
    }

    public InvoiceTestDataBuilder withPurchasedBook(PurchasedBook purchasedBook) {
        purchasedBooks.add(purchasedBook);
        return this;
    }

    public Invoice build() {
        Invoice invoice = new Invoice(clientName, country);
        invoice.addPurchasedBooks(purchasedBooks);
        return invoice;
    }
}
