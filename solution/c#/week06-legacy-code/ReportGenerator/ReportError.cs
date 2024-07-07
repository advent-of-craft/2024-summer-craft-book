namespace ReportGenerator
{
    public abstract record ReportError(string Message);

    public record NoDataToReport(string Message) : ReportError(Message);

    public record UnsupportedReportType(string Message) : ReportError(Message);
}