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

import com.murex.tbw.MainRepository;
import com.murex.tbw.domain.book.Book;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;

import java.util.HashMap;
import java.util.Map;

public final class BooksOrder implements Order {
    private final Map<Book, Integer> booksInBasket;
    private final Client client;

    public BooksOrder(Client client) {
        this.client = client;
        booksInBasket = new HashMap<>();
    }

    @Override
    public void addBook(Book book, int quantity) {
        booksInBasket.putIfAbsent(book, 0);
        booksInBasket.put(book, booksInBasket.get(book) + quantity);
    }

    @Override
    public Invoice checkOut() {
        Invoice invoice = new Invoice(client.getName(), client.getCountry());
        booksInBasket.forEach((book, quantity) -> invoice.addPurchasedBook(new PurchasedBook(book, quantity)));
        MainRepository.configuredRepository().addInvoice(invoice);
        return invoice;
    }

    @Override
    public Integer getQuantityOf(Book book) {
        return booksInBasket.getOrDefault(book, 0);
    }
}
