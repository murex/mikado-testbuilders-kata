package com.murex.tbw.purchase;

import com.google.common.collect.Lists;
import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.book.Genre;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.country.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.murex.tbw.domain.country.Currency.POUND_STERLING;
import static com.murex.tbw.domain.country.Currency.US_DOLLAR;
import static com.murex.tbw.domain.country.Language.ENGLISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {
    @Test
    void No_Constraint_Applies_tax_rules_when_computing_total_amount() {
        Invoice invoice = new Invoice("Client A", new Country("USA", US_DOLLAR, ENGLISH));

        Country unitedKingdom = new Country("United Kingdom", POUND_STERLING, ENGLISH);
        Author georgeOrwell = new Author("George Orwell", unitedKingdom);
        List<Genre> genres = Lists.newArrayList(Genre.ADVENTURE_FICTION);
        Novel novel1984 = new Novel("1984", 50, georgeOrwell, ENGLISH, genres);
        PurchasedBook book = new PurchasedBook(novel1984, 1);

        invoice.addPurchasedBook(book);

        assertEquals(56.35, invoice.computeTotalAmount());
    }

    @Test
    void Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        Novel novel1984 = NovelTestDataBuilder
                .aNovel()
                .withName("1984")
                .priced(50)
                .build();

        Invoice invoice = InvoiceTestDataBuilder
                .anInvoice()
                .forClient("Client A")
                .in(new Country("USA", US_DOLLAR, ENGLISH))
                .withPurchasedBook(new PurchasedBook(novel1984, 1))
                .build();

        assertEquals(56.35, invoice.computeTotalAmount());
    }

    @Test
    void Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }

    @Test
    void Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method and the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }
}
