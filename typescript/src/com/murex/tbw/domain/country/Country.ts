import {Currency} from "./Currency"
import {Language} from "./Language"

export class Country {
    private _name:String;
    private _currency:Currency;
    private _language:Language;

    public constructor(name: String, currency: Currency, language: Language)
    {
        this._name = name;
        this._currency = currency;
        this._language = language;
    }

    public get name(): String { return this._name; }
    public get currency(): Currency { return this._currency; }
    public get language(): Language { return this._language; }
}
