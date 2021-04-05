import { ReportGenerator } from "./tbw/report/ReportGenerator";

function main(): void {
  const reportGenerator = new ReportGenerator();

  console.log("****************************************************");
  console.log("*****************Application Report*****************");
  console.log("****************************************************");
  console.log();
  console.log(
    "The total number of books sold is: " + reportGenerator.getTotalSoldBooks()
  );
  console.log(
    "The total number of issued invoices is: " +
      reportGenerator.getNumberOfIssuedInvoices()
  );
  console.log(
    "The total amount of all invoices in USD is: " +
      reportGenerator.getTotalAmount()
  );
  console.log();
  console.log("****************************************************");
  console.log("****************************************************");
}

main();
