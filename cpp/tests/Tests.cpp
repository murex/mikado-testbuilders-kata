#include <gtest/gtest.h>
#include <report/ReportGenerator.h>

#include <domain/book/Author.h>
#include <domain/book/Novel.h>
#include <domain/country/Country.h>
#include <domain/country/Currency.h>
#include <purchase/Invoice.h>
#include <purchase/PurchasedBook.h>

#include <memory>

using namespace std;

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


class CountryBuilder
{
public:
   CountryBuilder() : m_currency(domain::country::Currency::YEN)
   {}

   CountryBuilder & withCurrency(const domain::country::Currency currency)
   {
      m_currency = currency;
      return *this;
   }

   domain::country::Country build()
   {
      return domain::country::Country("USA", m_currency, domain::country::Language::JAPANESE);
   }

private:
   domain::country::Currency m_currency;
};

class AuthorBuilder
{
public:
   AuthorBuilder() {}

   domain::book::Author build()
   {
      return domain::book::Author("Haruki Murakami", CountryBuilder().build());
   }
};

class NovelBuilder
{
public:
   NovelBuilder() : m_price(0.) {}

   NovelBuilder & withPrice(double price) {
      m_price = price;
      return *this;
   }

   domain::book::Novel build()
   {
      return domain::book::Novel("Norwegian Wood", m_price, AuthorBuilder().build(), domain::country::Language::JAPANESE, {});
   }
private:
   double m_price;
};

class BookBuilder
{
public:
   BookBuilder() : m_price(0.) {};

   BookBuilder & withPrice(double price) {
      m_price = price;
      return *this;
   }

   std::shared_ptr<domain::book::Book> build()
   {
      return std::make_shared<domain::book::Novel>(NovelBuilder().withPrice(m_price).build());
   }

private:
   double m_price;
};

class PurchasedBookBuilder
{
public:
   PurchasedBookBuilder() : m_price(0.) {}

   PurchasedBookBuilder & withPrice(double price) {
      m_price = price;
      return *this;
   }

   purchase::PurchasedBook build()
   {
      return purchase::PurchasedBook(BookBuilder().withPrice(m_price).build(), 1);
   }
private:
   double m_price;
};

class InvoiceBuilder
{
public:
   InvoiceBuilder() : m_price(0.), m_currency(domain::country::Currency::YEN) {}

   InvoiceBuilder & withBookCosting(double price)
   {
      m_price = price;
      return *this;
   }

   InvoiceBuilder & withCurrency(const domain::country::Currency currency)
   {
      m_currency = currency;
      return *this;
   }

   purchase::Invoice build()
   {
      purchase::Invoice invoice("Tony N.", CountryBuilder().withCurrency(m_currency).build());
      invoice.addPurchasedBook(std::make_shared<purchase::PurchasedBook>(PurchasedBookBuilder().withPrice(m_price).build()));
      return invoice;
   }

private:
   double m_price;
   domain::country::Currency m_currency;
};


TEST(Invoice, DISABLED_No_Constraint_Applies_tax_rules_when_computing_total_amount) {
	// Instantiate an Invoice sent to USA
	// Add it a purchased novel costing 50
	// Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
}

TEST(Invoice, DISABLED_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount) {
	// Using the Test Data Builder pattern:
	// Instantiate an Invoice sent to USA
	// Add it a purchased novel costing 50
	// Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
}

TEST(Invoice, DISABLED_Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount) {
	// Using the Mikado method:
	// Instantiate an Invoice sent to USA
	// Add it a purchased novel costing 50
	// Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
}

TEST(Invoice, Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount) {
	// Using the Mikado method and the Test Data Builder pattern:
	// Instantiate an Invoice sent to USA
	// Add it a purchased novel costing 50
	// Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels

   purchase::Invoice invoice = InvoiceBuilder()
      .withCurrency(domain::country::Currency::US_DOLLAR)
      .withBookCosting(50)
      .build();

   EXPECT_EQ(56.35,invoice.computeTotalAmount());
}

#pragma endregion Invoice_tests

/*

Target: Have an instance of Invoice
  - [ ] Create Invoice
      - [x] Create a Country
           - [x] Add currency (*)
           - [x] Add language
      - [x] Create a PurchasedBook
        - [x] Create a Novel
            - [x] Add Author
                - [x] Add Country
            - [x] Add Language
            - [x] Add Price (*)
 */
