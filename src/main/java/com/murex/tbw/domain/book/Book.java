/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

public interface Book {

    String getName();

    double getPrice();

    Author getAuthor();

    Language getLanguage();
}
