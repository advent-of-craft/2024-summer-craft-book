package report

fun main() {
    val generator = ReportGenerator(
        mapOf(
            ReportType.CSV to CsvReportGenerator(),
            ReportType.PDF to PdfReportGenerator()
        )
    )

    val data = listOf(
        ReportData(1, 100.0, "Sample Data 1"),
        ReportData(2, 200.0, "Sample Data 2")
    )

    generator.generateReport(ReportType.CSV, data)
        .fold(
            { error -> println("Error: $error") },
            { result -> println(result) }
        )
}