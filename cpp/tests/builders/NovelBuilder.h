#ifndef TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_NOVEL_BUILDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_NOVEL_BUILDER_H_INCLUDED 

#include <domain/book/Author.h>
#include <domain/country/Language.h>
#include <domain/book/Genre.h>
#include <domain/book/Novel.h>

using namespace domain::book;
using namespace domain::country;
using namespace std;

namespace builders
{
	class NovelBuilder
	{
	public:
		NovelBuilder() : m_name("aNovel"), 
			m_language(Language::ENGLISH), 
			m_genres({ }),
			m_price(0.0)
		{
			m_author = make_shared<Author>("Author Name", Country("Country", Currency::POUND_STERLING, Language::ENGLISH));
		}

		NovelBuilder & withName(const string name)
		{
			m_name = name;
			return *this;
		}

		NovelBuilder & withAuthor(const Author author)
		{
			m_author = make_shared<Author>(author);
			return *this;
		}

		NovelBuilder & withLanguage(const Language language)
		{
			m_language = language;
			return *this;
		}

		NovelBuilder & withGenres(const vector<Genre> genres)
		{
			m_genres = genres;
			return *this;
		}

		NovelBuilder & withPrice(const double price) 
		{
			m_price = price;
			return *this;
		}

		Novel build()
		{
			return Novel(m_name, m_price, *m_author, m_language, m_genres);
		}

	private:
		string m_name;
		double m_price;
		shared_ptr<Author> m_author;
		Language m_language;
		vector<Genre> m_genres;
	};
}

#endif //TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_NOVEL_BUILDER_H_INCLUDED