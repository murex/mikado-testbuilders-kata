package com.murex.tbw.report;

import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.storage.Repository;

import java.util.Map;

public class ReportGenerator {

    private final Repository repository;

    public ReportGenerator(Repository repository) {
        this.repository = repository;
    }

    public double getTotalCost() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        return invoiceMap.values().stream().mapToDouble(invoice -> invoice.computeTotalPrice()).sum();
    }
}
