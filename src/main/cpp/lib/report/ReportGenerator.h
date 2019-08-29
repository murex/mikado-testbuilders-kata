#ifndef TESTBUILDERS_WORKSHOP_REPORT_REPORT_GENERATOR_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_REPORT_REPORT_GENERATOR_H_INCLUDED

#include "MainRepository.h"

namespace storage {
	class Repository;
}

namespace report
{

class ReportGenerator
{
	const std::shared_ptr<const storage::Repository> repository_;

public:
	ReportGenerator();

	double getTotalAmount() const;
	int getTotalSoldBooks() const;
	size_t getNumberOfIssuedInvoices() const;
};
}

#endif // TESTBUILDERS_WORKSHOP_REPORT_REPORT_GENERATOR_H_INCLUDED
