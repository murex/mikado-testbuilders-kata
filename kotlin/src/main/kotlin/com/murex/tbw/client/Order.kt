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

interface Order {

    fun addBook(book: Book, quantity: Int)

    fun checkOut(): Invoice

    fun getQuantityOf(book: Book): Int

}