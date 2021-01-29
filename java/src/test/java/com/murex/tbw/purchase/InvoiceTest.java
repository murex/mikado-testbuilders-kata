package com.murex.tbw.purchase;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
    }

    @Test
    void Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method and the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }
}
