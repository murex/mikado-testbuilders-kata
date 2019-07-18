package com.murex.tbw.storage;

import com.murex.tbw.purchase.Invoice;

public interface Repository {
    void addInvoice(Invoice invoice);
}
