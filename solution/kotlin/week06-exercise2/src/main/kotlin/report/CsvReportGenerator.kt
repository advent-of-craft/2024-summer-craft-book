package report

import arrow.core.Either
import arrow.core.right

class CsvReportGenerator : CanGenerateReport {
    override fun generateReport(data: List<ReportData>): Either<ReportError, String> =
        buildString {
            appendLine("Starting CSV Report Generation...")
            appendLine("CSV Header: ID, Value, Description")
            data.forEach { d -> appendLine("${d.id},${d.value},${d.description}") }
            append("CSV Report Generated Successfully.")
        }.right()
}
