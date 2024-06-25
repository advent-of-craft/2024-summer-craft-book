import {ReportData} from "./reportData";

export class ReportGenerator {
    generateReport(reportType: string, data: ReportData[]): void {
        if (reportType === "CSV") {
            console.log("Starting CSV Report Generation...");
            console.log("CSV Header: ID, Value, Description");
            for (const d of data) {
                console.log(`${d.getId()},${d.getValue()},${d.getDescription()}`);
            }
            console.log("CSV Report Generated Successfully.");
        } else if (reportType === "PDF") {
            console.log("Starting PDF Report Generation...");
            console.log("PDF Report Title: Comprehensive Data Report");
            console.log("------------------------------------------------");
            for (const d of data) {
                console.log(`Data ID: ${d.getId()} | Data Value: ${d.getValue()} | Description: ${d.getDescription()}`);
            }
            console.log("------------------------------------------------");
            console.log("PDF Report Generated Successfully.");
        } else {
            console.log(`Report type ${reportType} not supported.`);
        }
    }
}