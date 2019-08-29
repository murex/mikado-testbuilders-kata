#include "client/BooksOrder.h"
#include "MainRepository.h"
#include "storage/Repository.h"
#include "purchase/PurchasedBook.h"

using namespace std;
using namespace purchase;
using namespace domain::book;

namespace client
{
	BooksOrder::BooksOrder(const Client& client) : client_(client)
	{
	}

	void BooksOrder::addBook(const shared_ptr<Book>& book, int quantity)
	{
		booksInBasket_[book] += quantity;
	}

	std::shared_ptr<Invoice> BooksOrder::checkOut()
	{
		std::shared_ptr<Invoice> invoice(std::make_shared<Invoice>(client_.getName(), client_.getCountry()));

		for (auto books_in_basket : booksInBasket_)
		{
			invoice->addPurchasedBook(std::make_shared<PurchasedBook>(books_in_basket.first, books_in_basket.second));
		}

		main_repository::configuredRepository()->addInvoice(invoice);

		return invoice;
	}

	int BooksOrder::getQuantityOf(const shared_ptr<Book>& book) const
	{
		if (booksInBasket_.find(book) == booksInBasket_.end())
			return 0;

		return booksInBasket_.at(book);
	}

}