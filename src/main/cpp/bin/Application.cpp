#include "report/ReportGenerator.h"
#include <iostream>

void main()
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
