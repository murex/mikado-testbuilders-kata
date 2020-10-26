/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw;

import com.murex.tbw.storage.JsonRepository;
import com.murex.tbw.storage.Repository;

public final class MainRepository {

    private static Repository runningRepository;

    private MainRepository() {
    }

    public static Repository configuredRepository() {
        if (runningRepository == null) {
            runningRepository = new JsonRepository();
        }
        return runningRepository;
    }

    /* Working effectively with Legacy Code
     * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
     */
    // TESTING ONLY
    public void override(Repository newRepository) {
        runningRepository = newRepository;
    }

    // TESTING ONLY
    public void reset() {
        runningRepository = new JsonRepository();
    }
}
