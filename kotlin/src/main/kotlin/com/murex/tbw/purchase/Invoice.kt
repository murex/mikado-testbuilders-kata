/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.purchase

import com.murex.tbw.domain.country.Country
import com.murex.tbw.finance.TaxRulesOperations

class Invoice(
    val clientName: String,
    val country: Country
) {
    private val purchasedBooks: ArrayList<PurchasedBook> = ArrayList()

    fun addBook(book: PurchasedBook) {
        purchasedBooks.add(book)
    }

    fun getPurchasedBooks(): List<PurchasedBook> {
        return purchasedBooks
    }

    fun computeTotalAmount(): Double {
        var sum = 0.0

        for (purchasedBook in purchasedBooks) {
//          BUG: There was a bug with the below line of code
//          val totalPrice: Double = purchasedBook.getTotalPrice()

//          FIX: The above bug was fixed by the below line
            val totalPrice: Double =
                purchasedBook.getTotalPrice() * TaxRulesOperations.getApplicableRate(country, purchasedBook.book)
            sum += totalPrice
        }
        return sum
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Invoice

        if (clientName != other.clientName) return false
        if (country != other.country) return false
        if (purchasedBooks != other.purchasedBooks) return false

        return true
    }

    override fun hashCode(): Int {
        var result = clientName.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + purchasedBooks.hashCode()
        return result
    }

    override fun toString(): String {
        return "Invoice(clientName='$clientName', country=$country, purchasedBooks=$purchasedBooks)"
    }


}