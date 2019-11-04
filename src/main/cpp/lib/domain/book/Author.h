/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_AUTHOR_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_AUTHOR_H_INCLUDED

#include <string>

#include "domain/country/Country.h"

namespace domain
{
namespace book
{

	class Author {

		const std::string name_;
		const country::Country nationality_;

	public:
		Author(const std::string& name, const country::Country& nationality);

		std::string getName() const
		{
			return name_;
		}

		country::Country getNationality() const {
			return nationality_;
		}
	};
}
}

#endif // TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_AUTHOR_H_INCLUDED