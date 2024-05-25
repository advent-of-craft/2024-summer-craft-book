package report;

import java.util.List;

class ReportGenerator {
    public void generateReport(String reportType, List<ReportData> data) {
        if ("CSV".equals(reportType)) {
            System.out.println("Starting CSV Report Generation...");
            System.out.println("CSV Header: ID, Value, Description");
            for (ReportData d : data) {
                System.out.println(d.getId() + "," + d.getValue() + "," + d.getDescription());
            }
            System.out.println("CSV Report Generated Successfully.");
        } else if ("PDF".equals(reportType)) {
            System.out.println("Starting PDF Report Generation...");
            System.out.println("PDF Report Title: Comprehensive Data Report");
            System.out.println("------------------------------------------------");
            for (ReportData d : data) {
                System.out.println("Data ID: " + d.getId() + " | " + "Data Value: " + d.getValue() + " | " + "Description: " + d.getDescription());
            }
            System.out.println("------------------------------------------------");
            System.out.println("PDF Report Generated Successfully.");
        } else {
            System.out.println("Report type " + reportType + " not supported.");
        }
    }
}

