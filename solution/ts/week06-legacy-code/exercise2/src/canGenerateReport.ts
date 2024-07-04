import {ReportData} from "./reportData";

export interface CanGenerateReport {
    generateReport(data: ReportData[]): string;
}