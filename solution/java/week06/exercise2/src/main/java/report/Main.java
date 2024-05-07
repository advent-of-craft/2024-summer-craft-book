package report;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );

        new CsvReportGenerator().generateReport(data);
        new PdfReportGenerator().generateReport(data);
    }
}
