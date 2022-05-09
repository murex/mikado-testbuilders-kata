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
