import { Country } from "../domain/country/Country";

export class Client {
  readonly name: string;
  readonly country: Country;

  public constructor(name: string, country: Country) {
    this.name = name;
    this.country = country;
  }
}
