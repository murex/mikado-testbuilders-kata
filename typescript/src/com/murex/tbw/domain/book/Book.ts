import { Author } from "./Author";
import { Language } from "../country/Language";

export interface Book {
  readonly name: string;
  readonly price: number;
  readonly author: Author;
  readonly language: Language;
}
