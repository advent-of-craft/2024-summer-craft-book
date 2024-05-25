package report;

import java.util.List;

public class CsvReportGenerator implements CanGenerateReport {
    @Override
    public String generateReport(List<ReportData> data) {
        StringBuilder sb = new StringBuilder("Starting CSV Report Generation...\nCSV Header: ID, Value, Description\n");
        data.forEach(d -> sb.append(d.getId()).append(",").append(d.getValue()).append(",").append(d.getDescription()).append("\n"));
        sb.append("CSV Report Generated Successfully.");
        return sb.toString();
    }
}
