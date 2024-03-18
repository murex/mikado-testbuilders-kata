package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.book.NovelTestDataBuilder;

import static com.murex.tbw.domain.book.NovelTestDataBuilder.aNovel;

public class PurchasedBookTestDataBuilder {
    private int quantity = 1;
    private Book book = aNovel().build();

    public static PurchasedBookTestDataBuilder aPurchase() {
        return new PurchasedBookTestDataBuilder();
    }

    public PurchasedBookTestDataBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PurchasedBookTestDataBuilder of(Book book) {
        this.book = book;
        return this;
    }

    public PurchasedBookTestDataBuilder of(NovelTestDataBuilder novelTestDataBuilder) {
        this.book = novelTestDataBuilder.build();
        return this;
    }

    public PurchasedBook build() {
        return new PurchasedBook(book, quantity);
    }
}
