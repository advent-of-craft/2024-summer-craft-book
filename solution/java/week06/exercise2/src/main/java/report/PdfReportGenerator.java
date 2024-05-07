package report;

import java.util.List;

public class PdfReportGenerator implements ReportGenerator {
    @Override
    public void generateReport(List<ReportData> data) {
        System.out.println("Starting PDF Report Generation...");

        generateHeader("PDF Report Title: Comprehensive Data Report");

        generateContent(data);

        System.out.println("PDF Report Generated Successfully.");
    }

    private static void generateContent(List<ReportData> data) {
        addSeparator();

        for (ReportData d : data) {
            System.out.println("Data ID: " + d.getId() + " | " + "Data Value: " + d.getValue() + " | " + "Description: " + d.getDescription());
        }

        addSeparator();
    }

    private static void addSeparator() {
        System.out.println("------------------------------------------------");
    }

    private static void generateHeader(String x) {
        System.out.println(x);
    }
}
