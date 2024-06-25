export class NoDataToReportError extends Error {
    constructor(message: string) {
        super(message);
        this.name = "NoDataToReportException";
    }
}
