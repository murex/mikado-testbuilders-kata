using Xunit;

namespace Application.Tests.Report
{
    public class ReportGeneratorTest
    {
        [Fact]
        public void Converts_total_amount_to_usd()
        {
            // Instantiate a ReportGenerator
            // It needs to use a data source that contains one invoice in a non-USD currency
            // Assert that the amount returned by ReportGenerator is converted to USD currency
            //
            // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
            // Don't forget to reset the data source at the end of your test!
        }
    }
}