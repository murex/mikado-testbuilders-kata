/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include "ReportGenerator.h"
#include <iostream>

int main()
{
	try
	{
		report::ReportGenerator reportGenerator;

		std::cout << "****************************************************" << std::endl;
		std::cout << "*****************Application Report*****************" << std::endl;
		std::cout << "****************************************************" << std::endl;
		std::cout << std::endl;
		std::cout << "The total number of books sold is: " << reportGenerator.getTotalSoldBooks() << std::endl;
		std::cout << "The total number of issued invoices is: " << reportGenerator.getNumberOfIssuedInvoices() << std::endl;
		std::cout << "The total amount of all invoices in USD is: " << reportGenerator.getTotalAmount() << std::endl;
		std::cout << std::endl;
		std::cout << "****************************************************" << std::endl;
		std::cout << "****************************************************" << std::endl;
	}
	catch (const std::exception &e)
	{
		std::cerr << e.what() << std::endl;
		return 1;
	}

	return 0;
}
