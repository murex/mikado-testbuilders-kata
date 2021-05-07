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

import com.murex.tbw.domain.book.Book

class PurchasedBook(
    val book: Book,
    val quantity: Int
) {

    fun getTotalPrice(): Double {
        return book.price * quantity
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PurchasedBook

        if (book != other.book) return false
        if (quantity != other.quantity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = book.hashCode()
        result = 31 * result + quantity
        return result
    }

    override fun toString(): String {
        return "PurchasedBook(book=$book, quantity=$quantity)"
    }
}