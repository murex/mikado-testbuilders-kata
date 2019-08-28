#ifndef TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_EDUCATIONAL_BOOK_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_EDUCATIONAL_BOOK_H_INCLUDED

#include "Book.h"
#include "Author.h"
#include "Category.h"
#include "domain/country/Language.h"

namespace domain
{
namespace book
{

	class EducationalBook : public Book {

		const std::string name_;
		const double price_;
		const Author author_;
		const country::Language language_;
		const Category category_;

	public:
		EducationalBook(std::string& name, double price, const Author& author, country::Language language, Category category)
			:  name_(name)
			, price_(price)
			, author_(author)
			, language_(language)
			, category_(category)
		{
		}

		virtual std::string getName() const
		{
			return name_;
		}

		virtual double getPrice() const
		{
			return price_;
		}

		virtual Author getAuthor() const{
			return author_;
		}

		virtual country::Language getLanguage() const
		{
			return language_;
		}

		Category getCategory() const {
			return category_;
		}
	};
}
}

#endif // TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_EDUCATIONAL_BOOK_H_INCLUDED
