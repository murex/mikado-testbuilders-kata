import { Book } from "../domain/book/Book";
import { Invoice } from "../purchase/Invoice";

export interface Order {
  addBook(book: Book, quantity: number): void;

  checkOut(): Invoice;

  getQuantityOf(book: Book): number;
}
