import { Repository } from "../storage/Repository";
import { MainRepository } from "../MainRepository";
import { toUSD } from "../finance/CurrencyConverter";

export class ReportGenerator {
  private readonly repository: Repository = MainRepository.configuredRepository();

  public getTotalAmount(): number {
    const invoiceMap = this.repository.getInvoiceMap();
    let totalAmount = 0.0;

    invoiceMap.valueSeq().forEach((invoice) => {
      // BUG: There was a bug with the below line of code
      // totalAmount += invoice.computeTotalAmount();

      // FIX: The above bug was fixed by the below 2 lines of code
      totalAmount += toUSD(
        invoice.computeTotalAmount(),
        invoice.country.currency
      );
    });
    return this.getRoundedAmount(totalAmount);
  }

  private getRoundedAmount(totalAmount: number): number {
    return Math.round(totalAmount * 100.0) / 100.0;
  }

  getTotalSoldBooks() {
    const invoiceMap = this.repository.getInvoiceMap();
    let totalSoldBooks = 0;

    invoiceMap.valueSeq().forEach((invoice) => {
      invoice.purchasedBooks.forEach((purchasedBook) => {
        totalSoldBooks = totalSoldBooks + purchasedBook.quantity;
      });
    });
    return totalSoldBooks;
  }

  getNumberOfIssuedInvoices() {
    const invoiceMap = this.repository.getInvoiceMap();
    return invoiceMap.size;
  }
}
