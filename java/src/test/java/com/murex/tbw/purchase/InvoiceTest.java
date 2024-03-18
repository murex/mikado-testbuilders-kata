package com.murex.tbw.purchase;

import com.murex.tbw.domain.country.TestCountries;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.domain.book.NovelTestDataBuilder.aNovel;
import static com.murex.tbw.purchase.InvoiceTestDataBuilder.anInvoice;
import static com.murex.tbw.purchase.PurchasedBookTestDataBuilder.aPurchase;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {
    @Test
    void No_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }

    @Test
    void Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
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

        Invoice invoice = anInvoice().sentTo(TestCountries.USA)
                .with(aPurchase().of(aNovel().costing(50))).build();

        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        assertEquals(56.35, invoice.computeTotalAmount());
    }
}
