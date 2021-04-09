/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.client

import com.murex.tbw.domain.book.Book
import com.murex.tbw.purchase.Invoice

class BooksOrder(val client: Client) : Order {
    private val booksInBasket: HashMap<Book, Int> = HashMap()

    override fun addBook(book: Book, quantity: Int) {
        booksInBasket[book] = booksInBasket[book]?.plus(quantity) ?: quantity
    }

    override fun checkOut(): Invoice {
        TODO("Not yet implemented")
    }

    override fun getQuantityOf(book: Book): Int {
        return booksInBasket.getOrDefault(book, 0);
    }


}

