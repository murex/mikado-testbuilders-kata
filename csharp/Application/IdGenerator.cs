/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

using System;

namespace Application
{
    public sealed class IdGenerator
    {
        private static readonly IdGenerator ID_GENERATOR = new IdGenerator();

        private int _currentId = 0;
        
        public static int NextId()
        {
            ID_GENERATOR._currentId += 1;
            return ID_GENERATOR._currentId;
        }
    }
}
