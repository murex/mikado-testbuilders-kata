/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.report;

import com.murex.tbw.MainRepository;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;
import com.murex.tbw.storage.Repository;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private final Repository repository = MainRepository.configuredRepository();

    public double getTotalAmount() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        double totalAmount = 0.0;
        for (Invoice invoice : invoiceMap.values()) {
            totalAmount += invoice.computeTotalAmount();
//            TODO Uncomment to fix the bug in ReportGenerator
//            totalAmount += CurrencyConverter.toUSD(invoice.computeTotalAmount(), invoice.getCountry().getCurrency());
        }
        return getRoundedAmount(totalAmount);
    }

    private double getRoundedAmount(double totalAmount) {
        return Math.round(totalAmount * 100.0) / 100.0;
    }

    public int getTotalSoldBooks() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        int totalSoldBooks = 0;
        for (Invoice invoice : invoiceMap.values()) {
            List<PurchasedBook> purchasedBooks = invoice.getPurchasedBooks();
            for (PurchasedBook purchasedBook : purchasedBooks) {
                totalSoldBooks += purchasedBook.getQuantity();
            }
        }
        return totalSoldBooks;
    }

    public long getNumberOfIssuedInvoices() {
        Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
        return invoiceMap.values().size();
    }
}
