/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include "domain/country/Country.h"

domain::country::Country::Country(const std::string& name, Currency currency, Language language): name_(name)
                                                                                                  , currency_(currency)
                                                                                                  , language_(language)
{
}
