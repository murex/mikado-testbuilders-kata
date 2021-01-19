using Xunit;

namespace Application.Tests.Purchase
{
    public class InvoiceTest
    {
        [Fact]
        public void Applies_tax_rules_when_computing_total_amount()
        {
            // Instantiate an Invoice sent to USA
            // Add it a purchased novel costing 50
            // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        }
    }
}