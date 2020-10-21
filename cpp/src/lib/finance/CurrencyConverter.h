/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_FINANCE_CURRENCY_CONVERTER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_FINANCE_CURRENCY_CONVERTER_H_INCLUDED

#include "domain/country/Currency.h"

namespace finance
{
	double fromUSD(double input, domain::country::Currency currency);
	double toUSD(double input, domain::country::Currency currency);
}

#endif // TESTBUILDERS_WORKSHOP_FINANCE_CURRENCY_CONVERTER_H_INCLUDED