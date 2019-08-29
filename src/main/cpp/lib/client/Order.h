#ifndef TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED

#include "domain/book/Book.h"
#include "purchase/Invoice.h"

namespace client
{
	class Order
	{
	public:
		virtual ~Order();

		virtual void addBook(const std::shared_ptr<domain::book::Book>&, int quantity) = 0;

		virtual std::shared_ptr<purchase::Invoice> checkOut() = 0;

		virtual int getQuantityOf(const std::shared_ptr<domain::book::Book>& book) const = 0;
	};

}

#endif // TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED
