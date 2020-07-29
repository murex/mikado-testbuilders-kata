#include "storage/InMemoryRepository.h"
#include "purchase/Invoice.h"

void storage::InMemoryRepository::addInvoice(const std::shared_ptr<purchase::Invoice>& invoice)
{
	invoiceMap_[invoice->getId()] = invoice;
}

std::map<int, std::shared_ptr<purchase::Invoice>> storage::InMemoryRepository::getInvoiceMap() const
{
	return invoiceMap_;
}
