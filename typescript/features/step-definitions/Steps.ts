import { Given, When, Then, setDefaultTimeout } from "cucumber";
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

Given("John, a customer from the USA", function () {
  this.invoice = new Invoice("John", USA);
});

When("John purchases a novel costing 50", function () {
  const steinbeck = new Author("John Steinbeck", USA);
  const grapesOfWrath = new Novel(
    "Grapes of Wrath",
    50,
    steinbeck,
    Language.English,
    Immutable.Set()
  );
  const purchasedBook = new PurchasedBook(grapesOfWrath, 1);
  this.invoice.addPurchasedBook(purchasedBook);
});

Then("the invoice total amount should be 56,35", function () {
  expect(this.invoice.computeTotalAmount()).to.equal(56.35);
});
