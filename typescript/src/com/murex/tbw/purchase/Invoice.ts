import { Country } from "../domain/country/Country";
import { getApplicableRate } from "../finance/TaxRule";
import { PurchasedBook } from "./PurchasedBook";
import { IdGenerator } from "../IdGenerator";

export class Invoice {
  readonly id: number;
  readonly clientName: string;
  readonly country: Country;
  readonly purchasedBooks: PurchasedBook[];

  public constructor(clientName: string, country: Country, id?: number) {
    this.id = id || IdGenerator.nextId();
    this.clientName = clientName;
    this.country = country;
    this.purchasedBooks = [];
  }

  public addPurchasedBook(purchasedBook: PurchasedBook) {
    this.purchasedBooks.push(purchasedBook);
  }
  public addPurchasedBooks(purchasedBooks: PurchasedBook[]) {
    purchasedBooks.forEach((purchasedBook) =>
      this.addPurchasedBook(purchasedBook)
    );
  }

  public computeTotalAmount(): number {
    let sum = 0.0;
    this.purchasedBooks.forEach((purchasedBook) => {
      // BUG: There was a bug with the below line of code
      // const totalPrice = purchasedBook.totalPrice();

      // FIX: The above bug was fixed by the below line
      const totalPrice =
        purchasedBook.totalPrice() *
        getApplicableRate(this.country, purchasedBook.book);
      sum = sum + totalPrice;
    });
    return sum;
  }
}
