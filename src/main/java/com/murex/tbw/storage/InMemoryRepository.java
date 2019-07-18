package com.murex.tbw.storage;

import com.murex.tbw.purchase.Invoice;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements Repository {
    private final Map<Integer, Invoice> invoiceMap;

    public InMemoryRepository() {
        this.invoiceMap = new HashMap<>();
    }

    @Override
    public void addInvoice(Invoice invoice) {
        invoiceMap.put(invoice.getId(), invoice);
    }
}
