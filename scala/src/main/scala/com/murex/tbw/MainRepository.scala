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
