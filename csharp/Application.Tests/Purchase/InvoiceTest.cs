using Xunit;

namespace Application.Tests.Purchase
{
    public class InvoiceTest
    {
        [Fact]
        public void No_Constraint_Applies_tax_rules_when_computing_total_amount()
        {
            // Instantiate an Invoice sent to USA
            // Add it a purchased novel costing 50
            // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        }

        [Fact]
        public void Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount()
        {
            // Using the Test Data Builder pattern:
            // Instantiate an Invoice sent to USA
            // Add it a purchased novel costing 50
            // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        }

        [Fact]
        public void Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount()
        {
            // Using the Mikado method:
            // Instantiate an Invoice sent to USA
            // Add it a purchased novel costing 50
            // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        }

        [Fact]
        public void Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount()
        {
            // Using the Mikado method and the Test Data Builder pattern:
            // Instantiate an Invoice sent to USA
            // Add it a purchased novel costing 50
            // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        }
    }
}