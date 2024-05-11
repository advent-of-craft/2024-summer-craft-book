package report;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var generator = new ReportGenerator(Map.of(
                ReportType.CSV, new CsvReportGenerator(),
                ReportType.PDF, new PdfReportGenerator()
        ));
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2"));

        var report = generator.generateReport(ReportType.CSV, data);
        report.onSuccess(System.out::println)
                .onFailure(System.err::println);
    }
}
