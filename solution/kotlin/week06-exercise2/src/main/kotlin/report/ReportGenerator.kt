package report

import arrow.core.*
import report.ReportError.NoDataToReport
import report.ReportError.UnsupportedReportType

class ReportGenerator(private val reportGenerators: Map<ReportType, CanGenerateReport>) {
    fun generateReport(reportType: ReportType, data: List<ReportData>): Either<ReportError, String> {
        if (data.isEmpty()) return NoDataToReport("No data provided for report generation.").left()

        return when (val generator = Option.fromNullable(reportGenerators[reportType])) {
            is Some -> generator.value.generateReport(data)
            is None -> UnsupportedReportType("Report type $reportType not supported.").left()
        }
    }
}
