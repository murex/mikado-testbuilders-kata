import { Country } from "../country/Country";

export class Author {
  readonly name: string;
  readonly nationality: Country;

  public constructor(name: string, nationality: Country) {
    this.name = name;
    this.nationality = nationality;
  }
}
