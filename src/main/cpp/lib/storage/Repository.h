/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

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

	virtual std::map<int, std::shared_ptr<purchase::Invoice>> getInvoiceMap() const = 0;
};
}

#endif // TESTBUILDERS_WORKSHOP_STORAGE_REPOSITORY_H_INCLUDED