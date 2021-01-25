#include "gtest/gtest.h"
#include "report/ReportGenerator.h"

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

TEST(Invoice, DISABLED_Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount) {
	// Using the Mikado method and the Test Data Builder pattern:
	// Instantiate an Invoice sent to USA
	// Add it a purchased novel costing 50
	// Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
}

#pragma endregion Invoice_tests