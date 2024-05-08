package report;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportGeneratorTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void generateReportInCSV() {
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );

        var generator = new ReportGenerator();
        var report = generator.generateReport(ReportType.CSV, data);
        report.onSuccess(System.out::println)
                .onFailure(System.err::println);

        Approvals.verify(outContent.toString());
    }

    @Test
    public void generateReportInPDF() {
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );

        var generator = new ReportGenerator();
        var report = generator.generateReport(ReportType.PDF, data);
        report.onSuccess(System.out::println)
                .onFailure(System.err::println);

        Approvals.verify(outContent.toString());
    }

    @Test
    public void generateReportInPDFShouldFailIfReportDataIsEmpty() {
        var generator = new ReportGenerator();
        var report = generator.generateReport(ReportType.PDF, null);
        report.onSuccess(System.out::println)
                .onFailure(System.err::println);

        assert report.isFailure();
        report.onFailure(ex -> {
            assertTrue(ex instanceof NoDataToReportException, "Expected a NoDataToReportException, but got " + ex.getClass().getSimpleName());
            assertEquals("No data provided for report generation.", ex.getMessage());
        });
    }

    @Test
    public void generateReportInPDFShouldFailIfReportTypeNotSupported() {
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );

        var generator = new ReportGenerator();
        var report = generator.generateReport(ReportType.Unsupported, data);
        report.onSuccess(System.out::println)
                .onFailure(System.err::println);

        assert report.isFailure();
        report.onFailure(ex -> {
            assertTrue(ex instanceof UnsupportedReportTypeException, "Expected a NoDataToReportException, but got " + ex.getClass().getSimpleName());
            assertEquals("Report type Unsupported not supported.", ex.getMessage());
        });
    }
}
