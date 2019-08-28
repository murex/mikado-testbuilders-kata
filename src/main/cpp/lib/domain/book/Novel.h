#ifndef TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_NOVEL_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_NOVEL_H_INCLUDED

#include "Book.h"
#include "Genre.h"
#include <vector>

namespace domain
{
	namespace book
	{

		class Novel : public Book
		{
			const std::string name_;
			const double price_;
			const Author author_;
			const country::Language language_;
			const std::vector<Genre> genres_;

			Novel(std::string& name, double price, const Author& author, country::Language language, const std::vector<Genre>& genres)
				: name_(name)
				, price_(price)
				, author_(author)
				, language_(language)
				, genres_(genres)
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

			virtual Author getAuthor() const
			{
				return author_;
			}

			virtual country::Language getLanguage() const
			{
				return language_;
			}

			std::vector<Genre> getGenres() const
			{
				return genres_;
			}
		};
	}
}

