import { Author } from "../../../../../src/com/murex/tbw/domain/book/Author";
import { Novel } from "../../../../../src/com/murex/tbw/domain/book/Novel";
import { Country } from "../../../../../src/com/murex/tbw/domain/country/Country";
import { Currency } from "../../../../../src/com/murex/tbw/domain/country/Currency";
import { Language } from "../../../../../src/com/murex/tbw/domain/country/Language";
import * as Immutable from "immutable";
import { Invoice } from "../../../../../src/com/murex/tbw/purchase/Invoice";
import { PurchasedBook } from "../../../../../src/com/murex/tbw/purchase/PurchasedBook";

describe(Invoice, () => {
  describe("No Constraint", () => {
    it("Applies tax rules when computing total amount", () => {
      // Instantiate an Invoice sent to USA
      // Add it a purchased novel costing 50
      // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    });
  });
  describe("Test Data Builders Constraint", () => {
    it("Applies tax rules when computing total amount", () => {
      // Using the Test Data Builder pattern:
      // Instantiate an Invoice sent to USA
      // Add it a purchased novel costing 50
      // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    });
  });
  describe("Mikado Method Constraint", () => {
    it("Applies tax rules when computing total amount", () => {
      // Using the Mikado method:
      // Instantiate an Invoice sent to USA
      // Add it a purchased novel costing 50
      // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    });
  });
  describe("Test Data Builders & Mikado Method Constraint", () => {
    it("Applies tax rules when computing total amount", () => {
      // Using the Mikado method and the Test Data Builder pattern:
      // Instantiate an Invoice sent to USA
      // Add it a purchased novel costing 50
      // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    });
  });
});
