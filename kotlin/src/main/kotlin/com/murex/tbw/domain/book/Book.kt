/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.domain.book

import com.murex.tbw.domain.country.Language

interface Book {
    val name: String
    val price: Double
    val author: Author
    val language: Language
}