#include "gtest/gtest.h"
#include "report/ReportGenerator.h"
#include <purchase/Invoice.h>
#include <domain/country/Country.h>
#include <domain/country/Currency.h>
#include <domain/country/Language.h>
#include <domain/book/Book.h>
#include <domain/book/Novel.h>
#include <purchase/PurchasedBook.h>
#include <builders/CountryBuilder.h>
#include <builders/AuthorBuilder.h>
#include <builders/NovelBuilder.h>
#include <builders/InvoiceBuilder.h>
#include <builders/PurchasedBookBuilder.h>

using namespace std;
using namespace builders;
using namespace domain::country;
using namespace domain::book;
using namespace purchase;

TEST(Books, DISABLED_empty_test)
{
	EXPECT_TRUE(false);
}

#pragma region Report_Generator_Tests

TEST(REPORT_GENERATOR, DISABLED_No_Constraint_Converts_total_amount_to_usd) {
	// Instantiate a ReportGenerator
	// It needs to use a data source that contains one invoice in a non-USD currency
	// Assert that the amount returned by ReportGenerator is converted to USD currency
	//
	// Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
	// Don't forget to reset the data source at the end of your test!
}

TEST(REPORT_GENERATOR, DISABLED_Test_Data_Builders_Constraint_Converts_total_amount_to_usd) {
	// Using the Test Data Builder pattern:
	// Instantiate a ReportGenerator
	// It needs to use a data source that contains one invoice in a non-USD currency
	// Assert that the amount returned by ReportGenerator is converted to USD currency
	//
	// Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
	// Don't forget to reset the data source at the end of your test!
}

TEST(REPORT_GENERATOR, DISABLED_Mikado_Method_Constraint_Converts_total_amount_to_usd) {
	// Using the Mikado method:
	// Instantiate a ReportGenerator
	// It needs to use a data source that contains one invoice in a non-USD currency
	// Assert that the amount returned by ReportGenerator is converted to USD currency
	//
	// Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
	// Don't forget to reset the data source at the end of your test!
}

TEST(REPORT_GENERATOR, DISABLED_Mikado_Method_And_Test_Data_Builders_Constraint_Converts_total_amount_to_usd) {
	// Using the Mikado method and the Test Data Builder pattern:
	// Instantiate a ReportGenerator
	// It needs to use a data source that contains one invoice in a non-USD currency
	// Assert that the amount returned by ReportGenerator is converted to USD currency
	//
	// Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
	// Don't forget to reset the data source at the end of your test!
}

#pragma endregion Report_Generator_Tests

#pragma region Invoice_tests 

TEST(Invoice, No_Constraint_Applies_tax_rules_when_computing_total_amount) {
	Country usa("USA", Currency::US_DOLLAR, Language::ENGLISH);

	Country uk("UK", Currency::POUND_STERLING, Language::ENGLISH);
	Author georgeOrwell("George Orwell", uk);
	vector<Genre> genres = { Genre::ADVENTURE_FICTION };
	shared_ptr<Book> novel1984(new Novel("1984", 50., georgeOrwell, Language::ENGLISH, genres));
	auto purchased1984 = make_shared<PurchasedBook>(novel1984, 1);

	Invoice invoice("Client A", usa);
	invoice.addPurchasedBook(purchased1984);

	EXPECT_EQ(56.35, invoice.computeTotalAmount());
}

TEST(Invoice, Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount) {
	Country usa = CountryBuilder().withName("USA")
								.withLanguage(Language::ENGLISH)
								.withCurrency(Currency::US_DOLLAR)
								.build();
	
	Country uk = CountryBuilder().withName("UK")
								.withLanguage(Language::ENGLISH)
								.withCurrency(Currency::POUND_STERLING)
								.build();
	
	Author georgeOrwell = AuthorBuilder().withName("George Orwell")
								.from(uk)
								.build();

	Novel novel1984 = NovelBuilder().withName("1984")
								.withLanguage(Language::ENGLISH)
								.withAuthor(georgeOrwell)
								.withGenres({ Genre::ADVENTURE_FICTION })
								.withPrice(50.0)
								.build();
	
	PurchasedBook purchased1984 = PurchasedBookBuilder().withBook(novel1984)
														.withQuantityOf(1)
														.build();

	Invoice invoice = InvoiceBuilder().withClientName("Client A")
									.withCountry(usa)
									.withBook(purchased1984)
									.build();

	EXPECT_EQ(56.35, invoice.computeTotalAmount());
}

TEST(Invoice, DISABLED_Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount) {
	// Using the Mikado method:
	// Instantiate an Invoice sent to USA
	// Add it a purchased novel costing 50
	// Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
}

TEST(Invoice, Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount) {
	Country usa = CountryBuilder().withName("USA")
		.build();

	Novel novel1984 = NovelBuilder().withName("1984")
		.withPrice(50.0)
		.build();

	PurchasedBook purchased1984 = PurchasedBookBuilder().withBook(novel1984)
		.withQuantityOf(1)
		.build();

	Invoice invoice = InvoiceBuilder().withClientName("Client A")
		.withCountry(usa)
		.withBook(purchased1984)
		.build();

	EXPECT_EQ(56.35, invoice.computeTotalAmount());
}

#pragma endregion Invoice_tests