#ifndef TESTBUILDERS_WORKSHOP_STORAGE_JSON_REPOSITORY_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_STORAGE_JSON_REPOSITORY_H_INCLUDED

#include <memory>
#include "Repository.h"

namespace purchase {
	class Invoice;
}

namespace storage
{
	class JsonRepository : public Repository
	{
		const std::string sourceFile_;
		std::map<int, std::shared_ptr<purchase::Invoice>> invoiceMap_;

	public:
		JsonRepository();

		void addInvoice(const std::shared_ptr<purchase::Invoice>& invoice) override;

		std::map<int, std::shared_ptr<purchase::Invoice>> getInvoiceMap() const override;

	private:
		
		void loadJsonData();
	};
}


#endif // TESTBUILDERS_WORKSHOP_STORAGE_JSON_REPOSITORY_H_INCLUDED