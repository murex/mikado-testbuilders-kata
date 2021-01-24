import { Language } from "../country/Language";
import { Author } from "./Author";
import { Book } from "./Book";
import { Category } from "./Category";

export class EducationalBook implements Book {
  readonly name: string;
  readonly price: number;
  readonly author: Author;
  readonly language: Language;
  readonly category: Category;

  public constructor(
    name: string,
    price: number,
    author: Author,
    language: Language,
    category: Category
  ) {
    this.name = name;
    this.price = price;
    this.author = author;
    this.language = language;
    this.category = category;
  }
}
