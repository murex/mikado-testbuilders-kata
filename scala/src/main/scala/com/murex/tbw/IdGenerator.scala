/*
 * ******************************************************************************
 *  *
 *  * Copyright (c) {2003-2022} Murex S.A.S. and its affiliates.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the MIT License
 *  * which accompanies this distribution, and is available at
 *  * https://opensource.org/licenses/MIT
 *  *
 *  ******************************************************************************
 */

package com.murex.tbw

import java.util.concurrent.atomic.AtomicInteger

object IdGenerator {
  private val currentId = new AtomicInteger(0)
  def nextId(): Int = currentId.incrementAndGet()
}
