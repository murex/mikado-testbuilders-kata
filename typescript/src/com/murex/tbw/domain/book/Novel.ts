import { Language } from "../country/Language";
import { Author } from "./Author";
import { Book } from "./Book";
import { Genre } from "./Genre";
import * as Immutable from "immutable";
import equal = require("fast-deep-equal");
import hash from "hash-it";

export function isNovel(book: Book): boolean {
  return (book as Novel).genres !== undefined;
}

export class Novel implements Book {
  readonly name: string;
  readonly price: number;
  readonly author: Author;
  readonly language: Language;
  readonly genres: Immutable.Set<Genre>;

  public constructor(
    name: string,
    price: number,
    author: Author,
    language: Language,
    genres: Immutable.Set<Genre>
  ) {
    this.name = name;
    this.price = price;
    this.author = author;
    this.language = language;
    this.genres = genres;
  }

  equals(other: any): boolean {
    return equal(this, other);
  }
  hashCode(): number {
    return hash(this);
  }
}
