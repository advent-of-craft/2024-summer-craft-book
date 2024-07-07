using System.Text;
using LanguageExt;

namespace ReportGenerator
{
    public class PdfReportGenerator : ICanGenerateReport
    {
        public Either<ReportError, string> GenerateReport(Seq<ReportData> data)
        {
            var sb = new StringBuilder();
            sb.AppendLine("Starting PDF Report Generation...");
            sb.AppendLine("PDF Report Title: Comprehensive Data Report");
            sb.AppendLine("------------------------------------------------");
            foreach (var d in data)
            {
                sb.AppendLine($"Data ID: {d.Id} | Data Value: {d.Value} | Description: {d.Description}");
            }

            sb.AppendLine("------------------------------------------------");
            sb.Append("PDF Report Generated Successfully.");
            return Prelude.Right<ReportError, string>(sb.ToString());
        }
    }
}