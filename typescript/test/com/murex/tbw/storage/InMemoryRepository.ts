import { Repository } from "../../../../../src/com/murex/tbw/storage/Repository";
import { Invoice } from "../../../../../src/com/murex/tbw/purchase/Invoice";
import * as Immutable from "immutable";

export class InMemoryRepository implements Repository {
  private invoices = Immutable.Map<number, Invoice>();

  addInvoice(invoice: Invoice): void {
    this.invoices = this.invoices.set(invoice.id, invoice);
  }

  getInvoiceMap(): Immutable.Map<number, Invoice> {
    return this.invoices;
  }
}
