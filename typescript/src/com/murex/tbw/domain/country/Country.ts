import { Currency } from "./Currency";
import { Language } from "./Language";

export class Country {
  readonly name: string;
  readonly currency: Currency;
  readonly language: Language;

  public constructor(name: string, currency: Currency, language: Language) {
    this.name = name;
    this.currency = currency;
    this.language = language;
  }
}
