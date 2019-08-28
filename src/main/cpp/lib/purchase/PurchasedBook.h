#ifndef TESTBUILDERS_WORKSHOP_PURCHASE_PURCHASED_BOOK_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_PURCHASE_PURCHASED_BOOK_H_INCLUDED

#include <memory>

namespace domain {
	namespace book {
		class Book;
	}
}

namespace purchase
{

	class PurchasedBook {
		const std::shared_ptr<const domain::book::Book> book_;
		const int quantity_;

	public:
		PurchasedBook(const std::shared_ptr<const domain::book::Book>& book, int quantity);

		std::shared_ptr<const domain::book::Book> getBook() const;

		int getQuantity() const;

		double getTotalPrice() const;
	};
}

#endif // TESTBUILDERS_WORKSHOP_PURCHASE_PURCHASED_BOOK_H_INCLUDED