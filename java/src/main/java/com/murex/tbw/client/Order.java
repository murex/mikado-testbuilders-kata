/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.client;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.purchase.Invoice;

public interface Order {
    void addBook(Book book, int quantity);

    Invoice checkOut();

    Integer getQuantityOf(Book book);
}
