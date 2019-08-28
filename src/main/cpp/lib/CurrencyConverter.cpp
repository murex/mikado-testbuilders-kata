#include "finance/CurrencyConverter.h"

#include "domain/country/Currency.h"
#include <map>

using namespace domain::country;

namespace
{
	std::map<Currency, double> EXCHANGE_RATE{
		{US_DOLLAR, 1.0},
		{EURO, 1.14 },
		{POUND_STERLING, 1.27 },
		{RENMINBI, 0.15 },
		{YEN, 0.0093 },
		{AUSTRALIAN_DOLLAR, 0.7 }
	};

}


double finance::fromUSD(double input, Currency currency)
{
	return input / EXCHANGE_RATE[currency];
}

double finance::toUSD(double input, Currency currency)
{
	return input * EXCHANGE_RATE[currency];
}
