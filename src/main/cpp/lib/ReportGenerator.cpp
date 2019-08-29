#include "report/ReportGenerator.h"
#include "storage/Repository.h"
#include "purchase/Invoice.h"
#include "purchase/PurchasedBook.h"

using namespace purchase;

namespace report
{

	ReportGenerator::ReportGenerator() : repository_(main_repository::configuredRepository())
	{
	}

	double ReportGenerator::getTotalAmount() const
	{
		const auto invoiceMap = repository_->getInvoiceMap();
		double totalAmount = 0.0;
		for (const auto id2Invoice : invoiceMap)
		{
			totalAmount += id2Invoice.second->computeTotalAmount();
		}
		return totalAmount;
	}

	int ReportGenerator::getTotalSoldBooks() const
	{
		const auto invoiceMap = repository_->getInvoiceMap();
		int totalSoldBooks = 0;
		for (const auto id2Invoice : invoiceMap)
		{
			for (const auto purchasedBook : id2Invoice.second->getPurchasedBooks())
			{
				totalSoldBooks += purchasedBook->getQuantity();
			}
		}
		return totalSoldBooks;
	}

	size_t ReportGenerator::getNumberOfIssuedInvoices() const
	{
		const auto invoiceMap = repository_->getInvoiceMap();
		return invoiceMap.size();
	}
}
