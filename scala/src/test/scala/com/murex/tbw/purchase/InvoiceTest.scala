package com.murex.tbw.purchase

import org.scalatest.funsuite.AnyFunSuite

class InvoiceTest extends AnyFunSuite {
  test("No_Constraint_Applies_tax_rules_when_computing_total_amount") {
    // Instantiate an Invoice sent to USA
    // Add it a purchased novel costing 50
    // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
  }

  test("Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount") {
    // Using the Test Data Builder pattern:
  }

  test("Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount") {
    // Using the Mikado method:
  }

  test(
    "Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount"
  ) {
    // Using the Mikado method and the Test Data Builder pattern:
  }
}
