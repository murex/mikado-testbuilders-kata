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

package com.murex

import com.murex.tbw.report.ReportGenerator

object Application {
  def main(args: Array[String]): Unit = {
    val reportGenerator = new ReportGenerator()

    println("****************************************************")
    println("*****************Application Report*****************")
    println("****************************************************")
    println()
    println("The total number of books sold is: " + reportGenerator.getTotalSoldBooks)
    println("The total number of issued invoices is: " + reportGenerator.getNumberOfIssuedInvoices)
    println("The total amount of all invoices in USD is: " + reportGenerator.getTotalAmount)
    println()
    println("****************************************************")
    println("****************************************************")
  }
}
