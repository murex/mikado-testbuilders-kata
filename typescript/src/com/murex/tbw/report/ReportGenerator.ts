import { Repository } from "../storage/Repository";
import { MainRepository } from "../MainRepository";
import { CurrencyConverter } from "../finance/CurrencyConverter";

export class ReportGenerator {
  private readonly repository: Repository = MainRepository.configuredRepository();

  public getTotalAmount(): number {
    const invoiceMap = this.repository.getInvoiceMap();
    let totalAmount = 0.0;

    invoiceMap.valueSeq().forEach((invoice) => {
      // BUG: There was a bug with the below line of code
      // totalAmount += invoice.computeTotalAmount();

      // FIX: The above bug was fixed by the below 2 lines of code
      totalAmount += CurrencyConverter.toUSD(
        invoice.computeTotalAmount(),
        invoice.country.currency
      );
    });
    return this.getRoundedAmount(totalAmount);
  }

  private getRoundedAmount(totalAmount: number): number {
    return Math.round(totalAmount * 100.0) / 100.0;
  }

  // public int getTotalSoldBooks() {
  //   Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
  //   int totalSoldBooks = 0;
  //   for (Invoice invoice : invoiceMap.values()) {
  //     List<PurchasedBook> purchasedBooks = invoice.getPurchasedBooks();
  //     for (PurchasedBook purchasedBook : purchasedBooks) {
  //       totalSoldBooks += purchasedBook.getQuantity();
  //     }
  //   }
  //   return totalSoldBooks;
  // }
  //
  // public long getNumberOfIssuedInvoices() {
  //   Map<Integer, Invoice> invoiceMap = repository.getInvoiceMap();
  //   return invoiceMap.values().size();
  // }
}
