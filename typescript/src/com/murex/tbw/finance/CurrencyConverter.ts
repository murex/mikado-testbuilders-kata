import * as Immutable from "immutable";
import { Currency } from "../domain/country/Currency";

export class CurrencyConverter {
  private static buildExchangeRateMap(): Immutable.Map<Currency, number> {
    let result = Immutable.Map<Currency, number>();
    result = result.set(Currency.Euro, 1.14);
    result = result.set(Currency.Dollar, 1.0);
    result = result.set(Currency.PoundSterling, 1.27);
    result = result.set(Currency.Renminbi, 0.15);
    result = result.set(Currency.Yen, 0.0093);
    result = result.set(Currency.AustralianDollar, 0.7);
    return result;
  }

  private static EXCHANGE_RATES: Immutable.Map<
    Currency,
    number
  > = CurrencyConverter.buildExchangeRateMap();

  public static fromUSD(input: number, currency: Currency): number {
    const exchangeRate = this.getExchangeRateOrThrow(currency);

    return input / exchangeRate;
  }

  public static toUSD(input: number, currency: Currency): number {
    const exchangeRate = this.getExchangeRateOrThrow(currency);

    return input / exchangeRate;
  }

  private static getExchangeRateOrThrow(currency: Currency) {
    const exchangeRate = this.EXCHANGE_RATES.get(currency);
    if (!exchangeRate)
      throw new Error("Unexpected currency " + currency.toString());

    return exchangeRate || 0;
  }
}
