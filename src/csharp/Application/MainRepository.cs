/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

using Application.Storage;

namespace Application
{
    public static class MainRepository
    {
        public static IRepository ConfiguredRepository { get; private set; } = new JsonRepository();

        /**
         * Working effectively with Legacy Code
         * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
         */
        // TESTING ONLY
        public static void Override(IRepository newRepository)
        {
            ConfiguredRepository = newRepository;
        }

        // TESTING ONLY
        public static void Reset()
        {
            ConfiguredRepository = new JsonRepository();
        }
    }
}
