/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#include "finance/TaxRule.h"
#include <map>
#include <string>
#include "domain/book/Novel.h"
#include <typeinfo>

namespace
{
	std::map<std::string, double> TAX_RATES =
	{
		{"USA", 1.15},
		{"France", 1.25},
		{"UK", 1.20},
		{"Spain", 1.10},
		{"China", 1.35},
		{"Japan", 1.30},
		{"Australia", 1.13},
		{"Germany", 1.22},
	};


	double getTaxRate(const std::string& country)
	{
		return TAX_RATES[country];
	}
}

double finance::getApplicableRate(const domain::country::Country& invoiceCountry, const domain::book::Book& book) {
	if (invoiceCountry.getName() == "Germany") {
		if (book.getAuthor().getNationality().getName() == "Germany") {
			return 1.05;
		}
	}
	//FIXME does this typeid(thing) work?
	if (invoiceCountry.getName() == "USA") {
		if (typeid(book).name() == std::string("class domain::book::Novel")) {
			return getTaxRate(invoiceCountry.getName()) * 0.98;
		}
	}
	if (invoiceCountry.getName() == "UK") {
		if (typeid(book).name() == std::string("class domain::book::Novel")) {
			return getTaxRate(invoiceCountry.getName()) * 0.93;
		}
	}
	if (invoiceCountry.getName() == "China") {
		if (book.getLanguage() != domain::country::MANDARIN) {
			return 1;
		}
	}
	if (invoiceCountry.getName() == "Spain") {
		if (book.getLanguage() != domain::country::SPANISH) {
			return 1;
		}
	}
	return getTaxRate(invoiceCountry.getName());
}