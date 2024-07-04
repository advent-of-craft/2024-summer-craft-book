import {ReportType} from "../src/reportType";
import {ReportGenerator} from "../src/reportGenerator";
import {CsvReportGenerator} from "../src/csvReportGenerator";
import {PdfReportGenerator} from "../src/pdfReportGenerator";
import {ReportData} from "../src/reportData";
import {JestReporter} from "approvals/lib/Providers/Jest/JestReporter";
import {configure} from "approvals";
import {fold} from "fp-ts/lib/Either";
import {verify} from "approvals/lib/Providers/Jest/JestApprovals";
import {NoDataToReportError} from "../src/noDataToReportError";
import {UnsupportedReportTypeError} from "../src/unsupportedReportTypeError";

const createReportGenerator = () => {
    return new ReportGenerator(new Map([
        [ReportType.CSV, new CsvReportGenerator()],
        [ReportType.PDF, new PdfReportGenerator()]
    ]));
};

const createReportData = () => {
    return [
        new ReportData(1, 100.0, "Sample Data 1"),
        new ReportData(2, 200.0, "Sample Data 2")
    ];
};

const verifyReport = (reportType: ReportType) => {
    fold(
        error => fail(error),
        report => verify(report)
    )(createReportGenerator().generateReport(reportType, createReportData()));
};

describe("documents", () => {
    beforeAll(() => {
        configure({
            reporters: [new JestReporter()],
        });
    });

    test('generate report in CSV', () => {
        verifyReport(ReportType.CSV);
    });

    test('generate report in PDF', () => {
        verifyReport(ReportType.PDF);
    });

    test('generate report should fail if report data is empty', () => {
        fold(
            (error: Error) => {
                expect(error).toBeInstanceOf(NoDataToReportError);
                expect(error.message).toBe("No data provided for report generation.");
            },
            () => fail("Should not generate a report without data")
        )(createReportGenerator().generateReport(ReportType.PDF, null));
    });

    test('generate report should fail if report type not supported', () => {
        fold(
            (error: Error) => {
                expect(error).toBeInstanceOf(UnsupportedReportTypeError);
                expect(error.message).toBe("Report type UNSUPPORTED not supported.");
            },
            () => fail()
        )(createReportGenerator().generateReport(ReportType.Unsupported, createReportData()));
    });
})