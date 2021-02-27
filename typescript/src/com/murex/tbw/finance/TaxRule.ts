import { Book } from "../domain/book/Book";
import { Country } from "../domain/country/Country";
import * as Immutable from "immutable";
import { Language } from "../domain/country/Language";
import { isNovel } from "../domain/book/Novel";

const taxRates = Immutable.Map({
  USA: 1.15,
  France: 1.25,
  UK: 1.2,
  Spain: 1.1,
  China: 1.35,
  Japan: 1.3,
  Australia: 1.13,
  Germany: 1.22,
});

function getTaxRate(countryName: string): number {
  const newLocal = taxRates.get(countryName);
  if (newLocal === undefined) {
    throw new Error("Unhandled country name: " + countryName);
  }
  return newLocal;
}

export function getApplicableRate(invoiceCountry: Country, book: Book): number {
  if (invoiceCountry.name === "Germany") {
    if (book.author.nationality.name === "Germany") {
      return 1.05;
    }
  }
  if (invoiceCountry.name === "USA") {
    if (isNovel(book)) {
      return getTaxRate(invoiceCountry.name) * 0.98;
    }
  }
  if (invoiceCountry.name === "UK") {
    if (isNovel(book)) {
      return getTaxRate(invoiceCountry.name) * 0.93;
    }
  }
  if (invoiceCountry.name === "China") {
    if (book.language !== Language.Mandarin) {
      return 1.0;
    }
  }
  if (invoiceCountry.name === "Spain") {
    if (book.language !== Language.Spanish) {
      return 1.0;
    }
  }
  return getTaxRate(invoiceCountry.name);
}
