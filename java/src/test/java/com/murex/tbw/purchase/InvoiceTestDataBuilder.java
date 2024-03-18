package com.murex.tbw.purchase;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.TestCountries;

import java.util.ArrayList;

public class InvoiceTestDataBuilder {

    private final ArrayList<PurchasedBook> purchasedBooks = new ArrayList<>();
    private Country country = TestCountries.USA;

    public static InvoiceTestDataBuilder anInvoice() {
        return new InvoiceTestDataBuilder();
    }

    public InvoiceTestDataBuilder with(PurchasedBookTestDataBuilder... purchasedBookTestDataBuilders) {
        for (PurchasedBookTestDataBuilder purchasedBookTestDataBuilder : purchasedBookTestDataBuilders) {
            purchasedBooks.add(purchasedBookTestDataBuilder.build());
        }
        return this;
    }

    public InvoiceTestDataBuilder sentTo(Country country) {
        this.country = country;
        return this;
    }

    public Invoice build() {
        Invoice invoice = new Invoice("John Doe", this.country);
        for (PurchasedBook purchasedBook : purchasedBooks) {
            invoice.addPurchasedBook(purchasedBook);
        }
        return invoice;
    }
}
