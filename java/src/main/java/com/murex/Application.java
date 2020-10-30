package com.murex; /*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

import com.murex.tbw.report.ReportGenerator;

public class Application {
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();

        System.out.println("****************************************************");
        System.out.println("*****************Application Report*****************");
        System.out.println("****************************************************");
        System.out.println();
        System.out.println("The total number of books sold is: " + reportGenerator.getTotalSoldBooks());
        System.out.println("The total number of issued invoices is: " + reportGenerator.getNumberOfIssuedInvoices());
        System.out.println("The total amount of all invoices in USD is: " + reportGenerator.getTotalAmount());
        System.out.println();
        System.out.println("****************************************************");
        System.out.println("****************************************************");
    }
}
