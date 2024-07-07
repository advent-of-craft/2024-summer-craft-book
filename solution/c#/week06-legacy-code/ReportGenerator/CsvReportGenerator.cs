using System.Text;
using LanguageExt;

namespace ReportGenerator
{
    public class CsvReportGenerator : ICanGenerateReport
    {
        public Either<ReportError, string> GenerateReport(Seq<ReportData> data)
        {
            var sb = new StringBuilder();
            sb.AppendLine("Starting CSV Report Generation...");
            sb.AppendLine("CSV Header: ID, Value, Description");
            foreach (var d in data)
            {
                sb.AppendLine($"{d.Id},{d.Value},{d.Description}");
            }

            sb.Append("CSV Report Generated Successfully.");
            return Prelude.Right<ReportError, string>(sb.ToString());
        }
    }
}