package com.murex.tbw

import java.util.concurrent.atomic.AtomicInteger

object IdGenerator {
  private val currentId = new AtomicInteger(0)
  def nextId(): Int = currentId.incrementAndGet()
}
