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

import com.murex.tbw.storage.{JsonRepository, Repository}

object MainRepository {
  private var runningRepository: Repository = _

  def configuredRepository(): Repository = {
    if (runningRepository == null) {
      runningRepository = new JsonRepository()
    }
    runningRepository
  }

  /* Working effectively with Legacy Code
   * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
   */
  // TESTING ONLY
  def `override`(newRepository: Repository): Unit = runningRepository = newRepository

  // TESTING ONLY
  def reset(): Unit = runningRepository = new JsonRepository()
}
