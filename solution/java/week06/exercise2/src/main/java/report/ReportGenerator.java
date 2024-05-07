package report;

import io.vavr.control.Try;

import java.util.List;
import java.util.Map;

class ReportGenerator {
    private final Map<ReportType, CanGenerateReport> reportGenerators;

    public ReportGenerator() {
        reportGenerators = Map.of(
                ReportType.CSV, new CsvReportGenerator(),
                ReportType.PDF, new PdfReportGenerator()
        );
    }

    public Try<String> generateReport(ReportType reportType, List<ReportData> data) {

        if (data == null || data.isEmpty()) {
            return Try.failure(new NoDataToReportException("No data provided for report generation."));
        }

        return Try.success(reportGenerators.get(reportType).generateReport(data));
    }

}

