#ifndef TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_COUNTRY_BUILDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_COUNTRY_BUILDER_H_INCLUDED

#include <domain/country/Country.h>
#include <domain/country/Currency.h>
#include <domain/country/Language.h>

using namespace domain::country;
using namespace std;

namespace builders
{
	class CountryBuilder
	{
	public:
		CountryBuilder() : m_name("USA")
			, m_currency(Currency::US_DOLLAR)
			, m_language(Language::ENGLISH)
		{}

		CountryBuilder & withCurrency(const Currency currency)
		{
			m_currency = currency;
			return *this;
		}

		CountryBuilder & withName(const string name)
		{
			m_name = name;
			return *this;
		}

		CountryBuilder & withLanguage(const Language language)
		{
			m_language = language;
			return *this;
		}

		Country build()
		{
			return Country(m_name, m_currency, m_language);
		}

	private:
		Currency m_currency;
		Language m_language;
		string m_name;
	};
}
#endif // TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_COUNTRY_BUILDER_H_INCLUDED