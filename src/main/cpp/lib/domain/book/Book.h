/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_BOOK_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_BOOK_H_INCLUDED

#include <string>

#include "domain/country/Language.h"
#include "Author.h"

namespace domain
{
	namespace book
	{

		class Book {
		public:
			virtual ~Book();

			virtual std::string getName() const = 0;
			virtual double getPrice() const = 0;
			virtual Author getAuthor() const = 0;
			virtual country::Language getLanguage() const = 0;
		};
	}
}

#endif // TESTBUILDERS_WORKSHOP_DOMAIN_BOOK_BOOK_H_INCLUDED