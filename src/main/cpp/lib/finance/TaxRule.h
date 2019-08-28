#ifndef TESTBUILDERS_WORKSHOP_FINANCE_TAX_RULE_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_FINANCE_TAX_RULE_H_INCLUDED

namespace domain
{
	namespace book
	{
		class Book;
	}
	namespace country
	{
		class Country;
	}
}

namespace finance
{
	double getApplicableRate(const domain::country::Country& invoiceCountry, const domain::book::Book& book);
}

#endif // TESTBUILDERS_WORKSHOP_FINANCE_TAX_RULE_H_INCLUDED
