import {CanGenerateReport} from "./canGenerateReport";
import {ReportData} from "./reportData";

export class PdfReportGenerator implements CanGenerateReport {
    generateReport(data: ReportData[]): string {
        let report = "Starting PDF Report Generation...\nPDF Report Title: Comprehensive Data Report\n------------------------------------------------\n";
        data.forEach(d => {
            report += `Data ID: ${d.id} | Data Value: ${d.value} | Description: ${d.description}\n`;
        });
        report += "------------------------------------------------\nPDF Report Generated Successfully.";
        return report;
    }
}
