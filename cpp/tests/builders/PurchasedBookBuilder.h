#ifndef TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_PURCHASED_BOOK_BUILDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_PURCHASED_BOOK_BUILDER_H_INCLUDED

#include <domain/book/Novel.h>
#include <purchase/PurchasedBook.h>

using namespace domain::book;
using namespace purchase;
using namespace std;

namespace builders
{
	class PurchasedBookBuilder
	{
	public:
		PurchasedBookBuilder() : m_quantity(1)
		{}

		PurchasedBookBuilder withQuantityOf(const int quantity)
		{
			m_quantity = quantity;
			return *this;
		}

		PurchasedBookBuilder withBook(Novel book)
		{
			m_book = make_shared<Novel>(book);
			return *this;
		}

		PurchasedBook build()
		{
			return PurchasedBook(m_book, m_quantity);
		}

	private:
		int m_quantity;
		shared_ptr<Novel> m_book;
	};
}

#endif //TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_PURCHASED_BOOK_BUILDER_H_INCLUDED