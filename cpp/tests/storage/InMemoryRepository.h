#ifndef TESTBUILDERS_WORKSHOP_TESTS_STORAGE_IN_MEMORY_REPOSITORY_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_TESTS_STORAGE_IN_MEMORY_REPOSITORY_H_INCLUDED

#include "storage/Repository.h"

namespace storage
{
	
class InMemoryRepository : public Repository
{
	std::map<int, std::shared_ptr<purchase::Invoice>> invoiceMap_;

public:

	void addInvoice(const std::shared_ptr<purchase::Invoice>& invoice) override;

	std::map<int, std::shared_ptr<purchase::Invoice>> getInvoiceMap() const override;
};

}

#endif // TESTBUILDERS_WORKSHOP_TESTS_STORAGE_IN_MEMORY_REPOSITORY_H_INCLUDED