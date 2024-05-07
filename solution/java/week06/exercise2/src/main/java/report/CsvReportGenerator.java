package report;

import java.util.List;

public class CsvReportGenerator implements ReportGenerator {
    @Override
    public void generateReport(List<ReportData> data) {
        System.out.println("Starting CSV Report Generation...");
        System.out.println("CSV Header: ID, Value, Description");
        for (ReportData d : data) {
            System.out.println(d.getId() + "," + d.getValue() + "," + d.getDescription());
        }
        System.out.println("CSV Report Generated Successfully.");
    }
}
