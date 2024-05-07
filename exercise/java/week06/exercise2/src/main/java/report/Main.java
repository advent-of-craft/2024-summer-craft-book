package report;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );
        generator.generateReport("CSV", data);
        generator.generateReport("PDF", data);
    }
}
