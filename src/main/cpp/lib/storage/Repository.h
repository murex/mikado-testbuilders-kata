#ifndef TESTBUILDERS_WORKSHOP_STORAGE_REPOSITORY_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_STORAGE_REPOSITORY_H_INCLUDED

#include <memory>
#include <map>

namespace purchase {
	class Invoice;
}

namespace storage
{
class Repository
{
public:
	virtual ~Repository();

	virtual void addInvoice(const std::shared_ptr<purchase::Invoice>& invoice) = 0;

	//FIXME should we put this const?
	virtual std::map<int, std::shared_ptr<purchase::Invoice>> getInvoiceMap() const = 0;
};
}

#endif // TESTBUILDERS_WORKSHOP_STORAGE_REPOSITORY_H_INCLUDED