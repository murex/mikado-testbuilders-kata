import { binding, given, then, when } from "cucumber-tsflow";
import { Author } from "../../src/com/murex/tbw/domain/book/Author";
import { Novel } from "../../src/com/murex/tbw/domain/book/Novel";
import { Country } from "../../src/com/murex/tbw/domain/country/Country";
import { Currency } from "../../src/com/murex/tbw/domain/country/Currency";
import { Language } from "../../src/com/murex/tbw/domain/country/Language";
import { Invoice } from "../../src/com/murex/tbw/purchase/Invoice";
import * as Immutable from "immutable";
import { PurchasedBook } from "../../src/com/murex/tbw/purchase/PurchasedBook";
import { expect } from "chai";

const USA = new Country("USA", Currency.Dollar, Language.English);

@binding()
export class InvoiceSteps {
  private invoice?: Invoice;

  @given("John, a customer from the USA")
  public johnACustomerFromTheUSA(): void {
    this.invoice = new Invoice("John", USA);
  }

  @when("John purchases a novel costing 50")
  public johnPurchasesANovelCosting50(): void {
    const steinbeck = new Author("John Steinbeck", USA);
    const grapesOfWrath = new Novel(
      "Grapes of Wrath",
      50,
      steinbeck,
      Language.English,
      Immutable.Set()
    );
    const purchasedBook = new PurchasedBook(grapesOfWrath, 1);
    this.invoice?.addPurchasedBook(purchasedBook);
  }

  @then("the invoice total amount should be 56,35")
  public theInvoiceTotalAmountShouldBe56_35(): void {
    expect(this.invoice?.computeTotalAmount()).to.equal(56.35);
  }
}
