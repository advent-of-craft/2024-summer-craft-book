package report;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
        ReportGenerator generator = new CsvReportGenerator();
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );
        generator.generateReport(data);

        Approvals.verify(outContent.toString());
    }

    @Test
    public void generateReportInPDF() {
        ReportGenerator generator = new PdfReportGenerator();
        List<ReportData> data = List.of(
                new ReportData(1, 100.0, "Sample Data 1"),
                new ReportData(2, 200.0, "Sample Data 2")
        );
        generator.generateReport(data);

        Approvals.verify(outContent.toString());
    }

    @Test
    public void generateReportInPDFShouldFailIfReportDataIsEmpty() {
        ReportGenerator generator = new PdfReportGenerator();
        List<ReportData> data = null;
        generator.generateReport(data);

        //TODO: assert exception
        Approvals.verify(outContent.toString());
    }
}
