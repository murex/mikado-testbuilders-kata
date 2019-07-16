package com.murex.tbw.purchase;

import org.junit.jupiter.api.Test;

import static com.murex.tbw.domain.book.builders.EducationalBookBuilder.newEducationalBookBuilder;
import static com.murex.tbw.domain.book.builders.NovelBuilder.newNovelBuilder;
import static com.murex.tbw.purchase.PurchasedBookBuilder.newPurchasedBookBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class PurchasedBookTest {

    @Test
    public void
    GetTotalPrice_OnPurchasedNovel_ShouldReturnTheQuantityMultipliedByUnitPrice() {
        assertEquals(104.8d,
                newPurchasedBookBuilder()
                        .setBook(newNovelBuilder()
                                .setName("Novel_A")
                                .setPrice(52.4)
                                .createNovel())
                        .setQuantity(2)
                        .createPurchasedBook()
                        .getTotalPrice()
        );
    }

    @Test
    public void
    GetTotalPrice_OnPurchasedEducationalBook_ShouldReturnTheQuantityMultipliedByUnitPrice() {
        assertEquals(304.5d,
                newPurchasedBookBuilder()
                        .setBook(newEducationalBookBuilder()
                                .setName("EducationalBook")
                                .setPrice(101.5)
                                .createEducationalBook())
                        .setQuantity(3)
                        .createPurchasedBook()
                        .getTotalPrice()
        );
    }
}