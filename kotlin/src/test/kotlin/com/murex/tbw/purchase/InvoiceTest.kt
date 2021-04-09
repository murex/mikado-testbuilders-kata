/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.purchase

import org.junit.jupiter.api.Test

internal class InvoiceTest {
    @Test
    fun No_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }

    @Test
    fun Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }

    @Test
    fun Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }

    @Test
    fun Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method and the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }
}
