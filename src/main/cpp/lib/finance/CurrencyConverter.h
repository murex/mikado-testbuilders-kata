#ifndef TESTBUILDERS_WORKSHOP_FINANCE_CURRENCY_CONVERTER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_FINANCE_CURRENCY_CONVERTER_H_INCLUDED

#include "domain/country/Currency.h"

namespace finance
{
	double fromUSD(double input, domain::country::Currency currency);
	double toUSD(double input, domain::country::Currency currency);
}

#endif // TESTBUILDERS_WORKSHOP_FINANCE_CURRENCY_CONVERTER_H_INCLUDED