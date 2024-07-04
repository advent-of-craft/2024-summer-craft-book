package report

import arrow.core.Either

interface CanGenerateReport {
    fun generateReport(data: List<ReportData>): Either<ReportError, String>
}