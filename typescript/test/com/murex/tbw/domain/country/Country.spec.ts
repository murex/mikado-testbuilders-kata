import { Country } from "../../../../../../src/com/murex/tbw/domain/country/Country";
import { Currency } from "../../../../../../src/com/murex/tbw/domain/country/Currency";
import { Language } from "../../../../../../src/com/murex/tbw/domain/country/Language";

describe("Country", () => {
  it("should have a name, currency, and language", () => {
    const usa: Country = new Country("USA", Currency.Dollar, Language.English);

    expect(usa.name).toEqual("USA");
    expect(usa.currency).toEqual(Currency.Dollar);
    expect(usa.language).toEqual(Language.English);
  });
});
