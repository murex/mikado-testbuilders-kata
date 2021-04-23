import { Repository } from "./Repository";
import { Invoice } from "../purchase/Invoice";
import * as Immutable from "immutable";
import jsonData from "./repository.json";
import { Country } from "../domain/country/Country";
import { Currency } from "../domain/country/Currency";
import { Language } from "../domain/country/Language";
import { PurchasedBook } from "../purchase/PurchasedBook";
import { Novel } from "../domain/book/Novel";
import { EducationalBook } from "../domain/book/EducationalBook";
import { Author } from "../domain/book/Author";
import { Category } from "../domain/book/Category";
import { Genre } from "../domain/book/Genre";

export class JsonRepository implements Repository {
  private readonly invoices = new Map<number, Invoice>();

  public constructor() {
    this.loadJsonData();
  }

  addInvoice(invoice: Invoice): void {
    this.invoices.set(invoice.id, invoice);
  }

  getInvoiceMap(): Immutable.Map<number, Invoice> {
    return Immutable.Map<number, Invoice>(this.invoices);
  }

  private loadJsonData() {
    jsonData.forEach((jsonInvoice) => {
      const country = JsonRepository.toCountry(jsonInvoice.country);
      const invoice = new Invoice(jsonInvoice.client, country, jsonInvoice.id);

      jsonInvoice.booksInBasket.forEach((jsonPurchasedBook) => {
        const jsonAuthor = jsonPurchasedBook.author;
        const author = new Author(
          jsonAuthor.name,
          JsonRepository.toCountry(jsonAuthor.nationality)
        );

        let book;
        if (jsonPurchasedBook.genre !== undefined) {
          let genres = Immutable.Set<Genre>();
          jsonPurchasedBook.genre.forEach((jsonGenre) => {
            genres = genres.add(JsonRepository.toGenre(jsonGenre));
          });
          book = new Novel(
            jsonPurchasedBook.name,
            jsonPurchasedBook.price,
            author,
            JsonRepository.toLanguage(jsonPurchasedBook.language),
            genres
          );
        } else {
          book = new EducationalBook(
            jsonPurchasedBook.name,
            jsonPurchasedBook.price,
            author,
            JsonRepository.toLanguage(jsonPurchasedBook.language),
            JsonRepository.toCategory(jsonPurchasedBook.category)
          );
        }

        const purchasedBook = new PurchasedBook(
          book,
          jsonPurchasedBook.quantity
        );
        invoice.addPurchasedBook(purchasedBook);
      });

      this.addInvoice(invoice);
    });
  }

  private static toCountry({
    currency,
    language,
    name,
  }: {
    currency: string;
    language: string;
    name: string;
  }) {
    return new Country(
      name,
      JsonRepository.toCurrency(currency),
      JsonRepository.toLanguage(language)
    );
  }

  private static toLanguage(jsonLanguage: string) {
    switch (jsonLanguage) {
      case "ARABIC":
        return Language.Arabic;
      case "ENGLISH":
        return Language.English;
      case "FRENCH":
        return Language.French;
      case "GERMAN":
        return Language.German;
      case "JAPANESE":
        return Language.Japanese;
      case "MANDARIN":
        return Language.Mandarin;
      case "SPANISH":
        return Language.Spanish;
    }

    throw new Error("Unhandled language name: " + jsonLanguage);
  }

  private static toCurrency(jsonCurrency: string): Currency {
    switch (jsonCurrency) {
      case "US_DOLLAR":
        return Currency.Dollar;
      case "EURO":
        return Currency.Euro;
      case "RENMINBI":
        return Currency.Renminbi;
      case "POUND_STERLING":
        return Currency.PoundSterling;
      case "AUSTRALIAN_DOLLAR":
        return Currency.AustralianDollar;
      case "YEN":
        return Currency.Yen;
    }

    throw new Error("Unhandled currency name: " + jsonCurrency);
  }

  private static toCategory(jsonCategory: string) {
    switch (jsonCategory) {
      case "BUSINESS":
        return Category.BUSINESS;
      case "COMPUTER":
        return Category.COMPUTER;
      case "LANGUAGE":
        return Category.LANGUAGE;
    }

    throw new Error("Unhandled category name: " + jsonCategory);
  }

  private static toGenre(jsonGenre: string) {
    switch (jsonGenre) {
      case "HORROR_FICTION":
        return Genre.HORROR_FICTION;
      case "THRILLER":
        return Genre.THRILLER;
      case "DARK_FANTASY":
        return Genre.DARK_FANTASY;
      case "MYSTERY":
        return Genre.MYSTERY;
      case "ADVENTURE_FICTION":
        return Genre.ADVENTURE_FICTION;
      case "NON_FICTION":
        return Genre.NON_FICTION;
      case "ROMANCE":
        return Genre.ROMANCE;
    }

    throw new Error("Unhandled genre name: " + jsonGenre);
  }
}
