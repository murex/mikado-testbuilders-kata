using Xunit;

namespace Application.Tests.Report
{
    public class ReportGeneratorTest
    {
        [Fact]
        public void No_Constraint_Converts_total_amount_to_usd()
        {
            // Instantiate a ReportGenerator
            // It needs to use a data source that contains one invoice in a non-USD currency
            // Assert that the amount returned by ReportGenerator is converted to USD currency
            //
            // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
            // Don't forget to reset the data source at the end of your test!
        }

        [Fact]
        public void Test_Data_Builders_Constraint_Converts_total_amount_to_usd()
        {
            // Using the Test Data Builder pattern:
            // Instantiate a ReportGenerator
            // It needs to use a data source that contains one invoice in a non-USD currency
            // Assert that the amount returned by ReportGenerator is converted to USD currency
            //
            // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
            // Don't forget to reset the data source at the end of your test!
        }

        [Fact]
        public void Mikado_Method_Constraint_Converts_total_amount_to_usd()
        {
            // Using the Mikado method:
            // Instantiate a ReportGenerator
            // It needs to use a data source that contains one invoice in a non-USD currency
            // Assert that the amount returned by ReportGenerator is converted to USD currency
            //
            // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
            // Don't forget to reset the data source at the end of your test!
        }

        [Fact]
        public void Mikado_Method_And_Test_Data_Builders_Constraint_Converts_total_amount_to_usd()
        {
            // Using the Mikado method and the Test Data Builder pattern:
            // Instantiate a ReportGenerator
            // It needs to use a data source that contains one invoice in a non-USD currency
            // Assert that the amount returned by ReportGenerator is converted to USD currency
            //
            // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
            // Don't forget to reset the data source at the end of your test!
        }
    }
}