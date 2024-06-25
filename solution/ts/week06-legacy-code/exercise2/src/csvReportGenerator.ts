import { CanGenerateReport } from './canGenerateReport';
import {ReportData} from "./reportData";

export class CsvReportGenerator implements CanGenerateReport {
    generateReport(data: ReportData[]): string {
        let report = "Starting CSV Report Generation...\nCSV Header: ID, Value, Description\n";
        data.forEach(d => {
            report += `${d.id},${d.value},${d.description}\n`;
        });
        report += "CSV Report Generated Successfully.";
        return report;
    }
}