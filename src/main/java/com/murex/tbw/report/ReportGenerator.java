package com.murex.tbw.report;

import com.murex.tbw.MainRepository;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;
import com.murex.tbw.storage.Repository;

import java.util.List;
import java.util.Map;

public class ReportGenerator {

    private final Repository repository = MainRepository.configuredRepository();

    public double getTotalAmount() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        return invoiceMap.values().stream().mapToDouble(Invoice::computeTotalAmount).sum();
    }

    public int getTotalSoldBooks() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        return invoiceMap.values().stream().mapToInt(invoice -> {
            List<PurchasedBook> purchasedBooks = invoice.getPurchasedBooks();
            return purchasedBooks.stream().mapToInt(PurchasedBook::getQuantity).sum();
        }).sum();
    }

    public long getNumberOfIssuedInvoices() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        return invoiceMap.values().size();
    }
}
