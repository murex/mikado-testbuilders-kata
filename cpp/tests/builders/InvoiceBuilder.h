#ifndef TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_INVOICE_BUILDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_INVOICE_BUILDER_H_INCLUDED

#include <domain/country/Country.h>
#include <purchase/PurchasedBook.h>
#include <purchase/Invoice.h>

using namespace domain::country;
using namespace purchase;
using namespace std;

namespace builders
{
	class InvoiceBuilder
	{
	public:
		InvoiceBuilder withClientName(const string clientName)
		{
			m_clientName = clientName;
			return *this;
		}

		InvoiceBuilder withCountry(const Country country)
		{
			m_country = make_shared<Country>(country);
			return *this;
		}

		InvoiceBuilder withBook(const PurchasedBook book)
		{
			m_purchasedBooks.push_back(make_shared<PurchasedBook>(book));
			return *this;
		}

		Invoice build()
		{
			Invoice invoice(m_clientName, *m_country);
			invoice.addPurchasedBooks(m_purchasedBooks);
			return invoice;
		}

	private:
		string m_clientName;
		shared_ptr<Country> m_country;
		vector<shared_ptr<const PurchasedBook>> m_purchasedBooks;
	};
}

#endif // TESTBUILDERS_WORKSHOP_TESTS_BUILDERS_INVOICE_BUILDER_H_INCLUDED