import * as Immutable from "immutable";
import { Currency } from "../domain/country/Currency";

const EXCHANGE_RATES = Immutable.Map<Currency, number>(
  new Map<Currency, number>([
    [Currency.Euro, 1.14],
    [Currency.Dollar, 1.0],
    [Currency.PoundSterling, 1.27],
    [Currency.Renminbi, 0.15],
    [Currency.Yen, 0.0093],
    [Currency.AustralianDollar, 0.7],
  ])
);

export function fromUSD(input: number, currency: Currency): number {
  const exchangeRate = getExchangeRateOrThrow(currency);

  return input / exchangeRate;
}

export function toUSD(input: number, currency: Currency): number {
  const exchangeRate = getExchangeRateOrThrow(currency);

  return input * exchangeRate;
}

function getExchangeRateOrThrow(currency: Currency) {
  const exchangeRate = EXCHANGE_RATES.get(currency);
  if (!exchangeRate)
    throw new Error("Unexpected currency " + currency.toString());

  return exchangeRate || 0;
}
