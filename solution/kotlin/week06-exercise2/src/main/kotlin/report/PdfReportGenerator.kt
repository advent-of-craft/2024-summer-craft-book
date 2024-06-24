package report

import arrow.core.Either
import arrow.core.right

class PdfReportGenerator : CanGenerateReport {
    override fun generateReport(data: List<ReportData>): Either<ReportError, String> {
        val report = buildString {
            appendLine("Starting PDF Report Generation...")
            appendLine("PDF Report Title: Comprehensive Data Report")
            appendLine("------------------------------------------------")
            data.forEach { d -> appendLine("Data ID: ${d.id} | Data Value: ${d.value} | Description: ${d.description}") }
            appendLine("------------------------------------------------")
            append("PDF Report Generated Successfully.")
        }
        return report.right()
    }
}