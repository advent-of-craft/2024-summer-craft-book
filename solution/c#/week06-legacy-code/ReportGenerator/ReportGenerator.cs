using LanguageExt;

namespace ReportGenerator
{
    public class ReportGenerator(Dictionary<ReportType, ICanGenerateReport> reportGenerators)
    {
        public Either<ReportError, string> GenerateReport(ReportType reportType, Seq<ReportData> data)
        {
            if (data.IsEmpty)
            {
                return new NoDataToReport("No data provided for report generation.");
            }

            return reportGenerators.TryGetValue(reportType, out var value)
                ? value.GenerateReport(data)
                : new UnsupportedReportType($"Report type {reportType} not supported.");
        }
    }
}