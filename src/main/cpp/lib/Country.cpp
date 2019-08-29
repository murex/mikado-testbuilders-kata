#include "domain/country/Country.h"

domain::country::Country::Country(const std::string& name, Currency currency, Language language): name_(name)
                                                                                                  , currency_(currency)
                                                                                                  , language_(language)
{
}
