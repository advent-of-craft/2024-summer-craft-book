package report;

import java.util.List;

public class PdfReportGenerator implements CanGenerateReport {
    @Override
    public String generateReport(List<ReportData> data) {
        StringBuilder sb = new StringBuilder("Starting PDF Report Generation...\nPDF Report Title: Comprehensive Data Report\n------------------------------------------------\n");
        data.forEach(d -> sb.append("Data ID: ").append(d.id()).append(" | ").append("Data Value: ").append(d.value()).append(" | ").append("Description: ").append(d.description()).append("\n"));
        sb.append("------------------------------------------------\nPDF Report Generated Successfully.");
        return sb.toString();
    }
}
