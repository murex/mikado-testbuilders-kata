import { ReportGenerator } from "../../../../../src/com/murex/tbw/report/ReportGenerator";
import { Country } from "../../../../../src/com/murex/tbw/domain/country/Country";
import { Currency } from "../../../../../src/com/murex/tbw/domain/country/Currency";
import { Language } from "../../../../../src/com/murex/tbw/domain/country/Language";
import { Author } from "../../../../../src/com/murex/tbw/domain/book/Author";
import { Novel } from "../../../../../src/com/murex/tbw/domain/book/Novel";
import * as Immutable from "immutable";
import { PurchasedBook } from "../../../../../src/com/murex/tbw/purchase/PurchasedBook";
import { InMemoryRepository } from "../storage/InMemoryRepository";
import { Invoice } from "../../../../../src/com/murex/tbw/purchase/Invoice";
import { MainRepository } from "../../../../../src/com/murex/tbw/MainRepository";

describe(ReportGenerator, () => {
  describe("No Constraint", () => {
    afterEach(() => {
      MainRepository.reset();
    });

    it("Converts to USD when computing total amount", () => {
      // Instantiate a ReportGenerator
      // It needs to use a data source that contains one invoice in a non-USD currency
      // Assert that the amount returned by ReportGenerator is converted to USD currency
      //
      // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
      // Don't forget to reset the data source at the end of your test!
    });
  });
  describe("Test Data Builders Constraint", () => {
    it("Converts to USD when computing total amount", () => {
      // Using the Test Data Builder pattern:
      // Instantiate a ReportGenerator
      // It needs to use a data source that contains one invoice in a non-USD currency
      // Assert that the amount returned by ReportGenerator is converted to USD currency
      //
      // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
      // Don't forget to reset the data source at the end of your test!
    });
  });
  describe("Mikado Method Constraint", () => {
    it("Converts to USD when computing total amount", () => {
      // Using the Mikado method:
      // Instantiate a ReportGenerator
      // It needs to use a data source that contains one invoice in a non-USD currency
      // Assert that the amount returned by ReportGenerator is converted to USD currency
      //
      // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
      // Don't forget to reset the data source at the end of your test!
    });
  });
  describe("Test Data Builders & Mikado Method Constraint", () => {
    it("Converts to USD when computing total amount", () => {
      // Using the Mikado method and the Test Data Builder pattern:
      // Instantiate a ReportGenerator
      // It needs to use a data source that contains one invoice in a non-USD currency
      // Assert that the amount returned by ReportGenerator is converted to USD currency
      //
      // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
      // Don't forget to reset the data source at the end of your test!
    });
  });
});
