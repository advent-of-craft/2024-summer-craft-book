package report

class ReportGenerator {
    fun generateReport(reportType: String, data: List<ReportData>) {
        when (reportType) {
            "CSV" -> {
                println("Starting CSV Report Generation...")
                println("CSV Header: ID, Value, Description")
                for (d in data) {
                    println("${d.id},${d.value},${d.description}")
                }
                println("CSV Report Generated Successfully.")
            }
            "PDF" -> {
                println("Starting PDF Report Generation...")
                println("PDF Report Title: Comprehensive Data Report")
                println("------------------------------------------------")
                for (d in data) {
                    println("Data ID: ${d.id} | Data Value: ${d.value} | Description: ${d.description}")
                }
                println("------------------------------------------------")
                println("PDF Report Generated Successfully.")
            }
            else -> println("Report type $reportType not supported.")
        }
    }
}

fun main() {
    val generator = ReportGenerator()
    val data = listOf(
        ReportData(1, 100.0, "Sample Data 1"),
        ReportData(2, 200.0, "Sample Data 2")
    )
    generator.generateReport("CSV", data)
    generator.generateReport("PDF", data)
}
