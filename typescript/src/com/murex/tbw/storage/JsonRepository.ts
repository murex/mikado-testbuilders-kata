import { Repository } from "./Repository";
import { Invoice } from "../purchase/Invoice";
import * as Immutable from "immutable";

export class JsonRepository implements Repository {
  addInvoice(invoice: Invoice): void {
    throw new Error("Not Implemented");
  }

  getInvoiceMap(): Immutable.Map<number, Invoice> {
    throw new Error("Not Implemented");
    // return Immutable.Map<number, Invoice>();
  }
}
