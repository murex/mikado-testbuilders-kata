import com.murex.tbw.MainRepository;
import com.murex.tbw.report.ReportGenerator;
import com.murex.tbw.storage.Repository;

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
