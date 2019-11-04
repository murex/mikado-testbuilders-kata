/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_FINANCE_TAX_RULE_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_FINANCE_TAX_RULE_H_INCLUDED

namespace domain
{
	namespace book
	{
		class Book;
	}
	namespace country
	{
		class Country;
	}
}

namespace finance
{
	double getApplicableRate(const domain::country::Country& invoiceCountry, const domain::book::Book& book);
}

#endif // TESTBUILDERS_WORKSHOP_FINANCE_TAX_RULE_H_INCLUDED
