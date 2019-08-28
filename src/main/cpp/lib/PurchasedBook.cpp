#include "purchase/PurchasedBook.h"
#include "domain/book/Book.h"

purchase::PurchasedBook::PurchasedBook(const std::shared_ptr<const domain::book::Book>& book, int quantity)
	: book_(book), quantity_(quantity)
{
}

std::shared_ptr<const domain::book::Book> purchase::PurchasedBook::getBook() const
{
	return book_;
}

int purchase::PurchasedBook::getQuantity() const
{
	return quantity_;
}

double purchase::PurchasedBook::getTotalPrice() const
{
	return book_->getPrice() * quantity_;
}
