package com.murex.tbw.storage;

import com.murex.tbw.purchase.Invoice;

import java.util.Map;

public interface Repository {
    void addInvoice(Invoice invoice);

    Map<Integer, Invoice> getInvoiceMap();
}
