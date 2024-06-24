package report

sealed class ReportError {
    data class NoDataToReport(val message: String) : ReportError()
    data class UnsupportedReportType(val message: String) : ReportError()
}