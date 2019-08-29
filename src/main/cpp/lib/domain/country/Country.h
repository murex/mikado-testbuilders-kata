#ifndef TESTBUILDERS_WORKSHOP_DOMAIN_COUNTRY_COUNTRY_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_DOMAIN_COUNTRY_COUNTRY_H_INCLUDED

#include <string>
#include "Currency.h"
#include "Language.h"

namespace domain
{
namespace country
{
	class Country {
		const std::string name_;
		const Currency currency_;
		const Language language_;

	public:
		Country(const std::string& name, Currency currency, Language language);

		std::string getName() const
		{
			return name_;
		}

		Language getLanguage() const
		{
			return language_;
		}

		Currency getCurrency() const
		{
			return currency_;
		}
	};
}
}


#endif // TESTBUILDERS_WORKSHOP_DOMAIN_COUNTRY_COUNTRY_H_INCLUDED