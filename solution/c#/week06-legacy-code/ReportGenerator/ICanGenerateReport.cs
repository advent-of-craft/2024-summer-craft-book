using LanguageExt;

namespace ReportGenerator
{
    public interface ICanGenerateReport
    {
        Either<ReportError, string> GenerateReport(Seq<ReportData> data);
    }
}