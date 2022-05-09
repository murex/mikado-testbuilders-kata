/*
 * ******************************************************************************
 *  *
 *  * Copyright (c) {2003-2022} Murex S.A.S. and its affiliates.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the MIT License
 *  * which accompanies this distribution, and is available at
 *  * https://opensource.org/licenses/MIT
 *  *
 *  ******************************************************************************
 */

package com.murex.tbw.report

import com.murex.tbw.MainRepository
import com.murex.tbw.finance.CurrencyOperations.toUSD

class ReportGenerator {
  private val repository = MainRepository.configuredRepository()

  def getTotalAmount: Double = {
    val invoiceMap = repository.getInvoiceMap
    var totalAmount = 0.0
    for (invoice <- invoiceMap.values) {
      // BUG: There was a bug with the below line of code
      // totalAmount += invoice.computeTotalAmount();

      // FIX: The above bug was fixed by the below 2 lines of code
      totalAmount += toUSD(invoice.computeTotalAmount, invoice.country.currency)
    }
    getRoundedAmount(totalAmount)
  }

  private def getRoundedAmount(totalAmount: Double): Double = (totalAmount * 100.0).round / 100.0

  def getTotalSoldBooks: Int = {
    val invoiceMap = repository.getInvoiceMap
    var totalSoldBooks = 0
    for (invoice <- invoiceMap.values) {
      val purchasedBooks = invoice.getPurchasedBooks
      for (purchasedBook <- purchasedBooks) {
        totalSoldBooks += purchasedBook.quantity
      }
    }
    totalSoldBooks
  }

  def getNumberOfIssuedInvoices: Long = repository.getInvoiceMap.values.size.toLong
}
