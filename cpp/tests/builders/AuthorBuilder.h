#ifndef TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_AUTHOR_BUILDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_AUTHOR_BUILDER_H_INCLUDED

#include <domain/country/Country.h>
#include <domain/country/Currency.h>
#include <domain/country/Language.h>
#include <domain/book/Author.h>

using namespace domain::country;
using namespace domain::book;
using namespace std;

namespace builders
{
	class AuthorBuilder
	{
	public:
		AuthorBuilder() : m_name("George Orwell"),
			m_country(make_shared<Country>("USA", Currency::YEN, Language::ENGLISH))
		{}

		AuthorBuilder & withName(const string name)
		{
			m_name = name;
			return *this;
		}

		AuthorBuilder & from(const Country country)
		{
			m_country = make_shared<Country>(country);
			return *this;
		}

		Author build()
		{
			return Author(m_name, *m_country);
		}

	private:
		string m_name;
		shared_ptr<Country> m_country;
	};
}

#endif // TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_AUTHOR_BUILDER_H_INCLUDED