/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_REPORT_REPORT_GENERATOR_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_REPORT_REPORT_GENERATOR_H_INCLUDED

#include "MainRepository.h"

#include <memory>

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
