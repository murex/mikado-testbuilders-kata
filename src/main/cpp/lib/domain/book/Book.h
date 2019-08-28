#ifndef TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_BOOK_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_BOOK_H_INCLUDED

#include <string>

#include "domain/country/Language.h"
#include "Author.h"

namespace domain
{
	namespace book
	{

		class Book {
		public:
			virtual ~Book();

			virtual std::string vrtName() const = 0;
			virtual double getPrice() const = 0;
			virtual Author getAuthor() const = 0;
			virtual country::Language getLanguage() const = 0;
		};
	}
}

#endif // TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_BOOK_H_INCLUDED