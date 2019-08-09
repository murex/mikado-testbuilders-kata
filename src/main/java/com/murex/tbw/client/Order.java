package com.murex.tbw.client;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.purchase.Invoice;

public interface Order {
    void addBook(Book book, int quantity);

    Invoice checkOut();

    Integer getQuantityOf(Book book);
}
