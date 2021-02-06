import { Book } from "../domain/book/Book";

export class PurchasedBook {
  readonly book: Book;
  readonly quantity: number;

  public constructor(book: Book, quantity: number) {
    this.book = book;
    this.quantity = quantity;
  }

  public totalPrice(): number {
    return this.book.price * this.quantity;
  }
}
