package report;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ReportGeneratorTests {

    private static ReportGenerator createReportGenerator() {
        return new ReportGenerator(Map.of(
                ReportType.CSV, new CsvReportGenerator(),
                ReportType.PDF, new PdfReportGenerator()
        ));
    }

    private static List<ReportData> createReportData() {
        return List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );
    }

    @Test
    void generateReportInCSV() {
        createReportGenerator()
                .generateReport(ReportType.CSV, createReportData())
                .onSuccess(Approvals::verify)
                .onFailure(Assertions::fail);
    }

    @Test
    void generateReportInPDF() {
        createReportGenerator()
                .generateReport(ReportType.PDF, createReportData())
                .onSuccess(Approvals::verify)
                .onFailure(Assertions::fail);
    }

    @Test
    void generateReportInPDFShouldFailIfReportDataIsEmpty() {
        createReportGenerator()
                .generateReport(ReportType.PDF, null)
                .onSuccess(Assertions::fail)
                .onFailure(ex -> {
                    assertInstanceOf(NoDataToReportException.class, ex, "Expected a NoDataToReportException, but got " + ex.getClass().getSimpleName());
                    assertEquals("No data provided for report generation.", ex.getMessage());
                });
    }

    @Test
    void generateReportInPDFShouldFailIfReportTypeNotSupported() {
        createReportGenerator()
                .generateReport(ReportType.UNSUPPORTED, createReportData())
                .onSuccess(Assertions::fail)
                .onFailure(ex -> {
                    assertInstanceOf(UnsupportedReportTypeException.class, ex, "Expected a NoDataToReportException, but got " + ex.getClass().getSimpleName());
                    assertEquals("Report type Unsupported not supported.", ex.getMessage());
                });
    }
}
