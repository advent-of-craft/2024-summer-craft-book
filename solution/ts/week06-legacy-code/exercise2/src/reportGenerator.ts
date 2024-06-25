import {fold, fromNullable} from 'fp-ts/lib/Option';

import {NoDataToReportError} from './noDataToReportError';
import {Either, left, right} from "fp-ts/Either";
import {ReportType} from "./reportType";
import {CanGenerateReport} from "./canGenerateReport";
import {ReportData} from "./reportData";
import {UnsupportedReportTypeError} from "./unsupportedReportTypeError";

export class ReportGenerator {
    constructor(private reportGenerators: Map<ReportType, CanGenerateReport>) {
    }

    generateReport(reportType: ReportType, data: ReportData[]): Either<Error, string> {
        if (!data || data.length === 0) {
            return left(new NoDataToReportError("No data provided for report generation."));
        }

        return fold(
            () => left(new UnsupportedReportTypeError("Report type " + reportType + " not supported.")),
            (g: CanGenerateReport) => right(g.generateReport(data))
        )(fromNullable(this.reportGenerators.get(reportType)));
    }
}