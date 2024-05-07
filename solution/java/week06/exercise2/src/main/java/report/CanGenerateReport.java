package report;

import java.util.List;

public interface CanGenerateReport {
    String generateReport(List<ReportData> data);
}
