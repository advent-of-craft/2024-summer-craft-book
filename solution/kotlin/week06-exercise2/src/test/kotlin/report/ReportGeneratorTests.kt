package report

import io.kotest.assertions.arrow.core.shouldBeLeft
import org.approvaltests.Approvals.verify
import org.junit.jupiter.api.Test

class ReportGeneratorTests {
    @Test
    fun generateReportInCSV() {
        createReportGenerator()
            .generateReport(ReportType.CSV, createReportData())
            .getOrNull()!!
            .let { report -> verify(report) }
    }

    @Test
    fun generateReportInPDF() {
        createReportGenerator()
            .generateReport(ReportType.CSV, createReportData())
            .getOrNull()!!
            .let { report -> verify(report) }
    }

    @Test
    fun generateReportInPDFShouldFailIfReportDataIsEmpty() {
        createReportGenerator()
            .generateReport(ReportType.CSV, emptyList())
            .shouldBeLeft(ReportError.NoDataToReport("No data provided for report generation."))
    }

    @Test
    fun generateReportInPDFShouldFailIfReportTypeNotSupported() {
        createReportGenerator()
            .generateReport(ReportType.Unsupported, createReportData())
            .shouldBeLeft(ReportError.UnsupportedReportType("Report type Unsupported not supported."))
    }

    private fun createReportGenerator(): ReportGenerator {
        return ReportGenerator(
            mapOf(
                ReportType.CSV to CsvReportGenerator(),
                ReportType.PDF to PdfReportGenerator()
            )
        )
    }

    private fun createReportData(): List<ReportData> {
        return listOf(
            ReportData(1, 100.0, "Sample Data 1"),
            ReportData(2, 200.0, "Sample Data 2")
        )
    }
}
