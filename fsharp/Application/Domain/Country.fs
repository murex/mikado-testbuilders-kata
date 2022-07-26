namespace Application.Domain

type Currency = 
    | UsDollar
    | AustralianDollar
    | Euro
    | PoundSterling
    | Yen
    | Reminbi

type Language =
    | English
    | French
    | Spanish
    | Japanese
    | Mandarin
    | Arabic
    | German

type CountryName =
    | USA
    | France
    | UK
    | Spain
    | China
    | Japan
    | Australia
    | Germany

type Country = {
    Name: CountryName
    Currency: Currency
    Language: Language
}

