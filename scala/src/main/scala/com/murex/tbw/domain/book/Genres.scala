package com.murex.tbw.domain.book

object Genres extends Enumeration {
  type Genre = Value
  val HORROR_FICTION, THRILLER, DARK_FANTASY, MYSTERY, ADVENTURE_FICTION, NON_FICTION, ROMANCE =
    Value
}
