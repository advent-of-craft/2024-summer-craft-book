export class UnsupportedReportTypeError extends Error {
    constructor(message: string) {
        super(message);
        this.name = "UnsupportedReportTypeError";
    }
}