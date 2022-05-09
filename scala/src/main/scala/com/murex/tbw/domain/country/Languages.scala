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

package com.murex.tbw.domain.country

object Languages extends Enumeration {
  type Language = Value
  val ENGLISH, FRENCH, SPANISH, JAPANESE, MANDARIN, ARABIC, GERMAN = Value
}
