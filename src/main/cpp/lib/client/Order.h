#ifndef TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED

#include "domain/book/Book.h"
#include "purchase/Invoice.h"

namespace client
{
	class Order
	{
	public:
		virtual void addBook(const domain::book::Book& book, int quantity);

		virtual purchase::Invoice checkOut();

		virtual int getQuantityOf(const domain::book::Book& book) const;
	};

}

#endif // TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED
