package com.murex.tbw.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.domain.book.builders.EducationalBookBuilder.newEducationalBookBuilder;
import static com.murex.tbw.domain.book.builders.NovelBuilder.newNovelBuilder;
import static com.murex.tbw.domain.country.CountryBuilder.newCountryBuilder;
import static com.murex.tbw.purchase.PurchasedBookBuilder.newPurchasedBookBuilder;

public class InvoiceTest {

    private static final PurchasedBook ENGLISH_FOR_BEGINNERS =
            newPurchasedBookBuilder().setBook(
                    newEducationalBookBuilder()
                            .setName("ENGLISH For Beginners")
                            .setPrice(30)
                            .createEducationalBook())
                    .setQuantity(1)
                    .createPurchasedBook();

    private static final PurchasedBook NOVEL_A =
            newPurchasedBookBuilder().setBook(
                    newNovelBuilder()
                            .setName("NovelA")
                            .setPrice(20)
                            .createNovel())
                    .setQuantity(2)
                    .createPurchasedBook();

    @Test
    public void
    WhenComputingTotalPrice_ItShouldReturnThePriceSumOfAllItemsInTheInvoice() {
        Invoice invoice = new Invoice("User_A", newCountryBuilder().createCountry());

        invoice.addPurchasedBook(NOVEL_A);
        invoice.addPurchasedBook(ENGLISH_FOR_BEGINNERS);

        Assertions.assertEquals(70, invoice.computeTotalPrice());
    }
}