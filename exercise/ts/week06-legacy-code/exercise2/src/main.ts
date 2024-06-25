import {ReportGenerator} from "./reportGenerator";
import {ReportData} from "./reportData";

const generator = new ReportGenerator();
const data = [
    new ReportData(1, 100.0, "Sample Data 1"),
    new ReportData(2, 200.0, "Sample Data 2")
];

generator.generateReport("CSV", data);
generator.generateReport("PDF", data);