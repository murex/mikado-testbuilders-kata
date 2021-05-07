/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.report

import com.murex.tbw.MainRepository
import com.murex.tbw.finance.CurrencyOperations
import kotlin.math.roundToInt

class ReportGenerator {

    private val repository = MainRepository.configuredRepository()

    fun getTotalAmount(): Double {
        val invoiceMap = repository.getInvoiceMap()
        var totalAmount = 0.0
        for (invoice in invoiceMap.values) {
//          BUG: There was a bug with the below line of code
//          totalAmount += invoice.computeTotalAmount();

//          FIX: The above bug was fixed by the below 2 lines of code
            totalAmount += CurrencyOperations.toUSD(invoice.computeTotalAmount(), invoice.country.currency)
        }
        return getRoundedAmount(totalAmount)
    }

    private fun getRoundedAmount(totalAmount: Double): Double {
        return (totalAmount * 100.0).roundToInt() / 100.0
    }

    fun getTotalSoldBooks(): Int {
        val invoiceMap = repository.getInvoiceMap()
        var totalSoldBooks = 0
        for (invoice in invoiceMap.values) {
            val purchasedBooks = invoice.getPurchasedBooks()
            for (purchasedBook in purchasedBooks) {
                totalSoldBooks += purchasedBook.quantity
            }
        }
        return totalSoldBooks
    }

    fun getNumberOfIssuedInvoices(): Long {
        val invoiceMap = repository.getInvoiceMap()
        return invoiceMap.values.size.toLong()
    }
}