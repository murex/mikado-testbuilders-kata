import {Currency} from "./Currency"
import {Language} from "./Language"

export class Country {
    readonly name:String;
    readonly currency:Currency;
    readonly language:Language;

    public constructor(name: String, currency: Currency, language: Language)
    {
        this.name = name;
        this.currency = currency;
        this.language = language;
    }
}
