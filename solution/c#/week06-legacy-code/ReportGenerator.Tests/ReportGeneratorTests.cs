using FluentAssertions;
using FluentAssertions.LanguageExt;
using LanguageExt;
using LanguageExt.UnsafeValueAccess;

namespace ReportGenerator.Tests
{
    public class ReportGeneratorTests
    {
        [Fact]
        public Task Generate_Report_In_Csv() =>
            Verify(
                CreateReportGenerator()
                    .GenerateReport(ReportType.Csv, CreateReportData())
                    .ValueUnsafe()
            );

        [Fact]
        public Task Generate_Report_In_Pdf() =>
            Verify(
                CreateReportGenerator()
                    .GenerateReport(ReportType.Pdf, CreateReportData())
                    .ValueUnsafe()
            );

        [Fact]
        public void Generate_Report_Should_Fail_If_Report_Data_Is_Empty() =>
            CreateReportGenerator()
                .GenerateReport(ReportType.Pdf, [])
                .Should()
                .BeLeft(error => error
                    .Should()
                    .Be(new NoDataToReport("No data provided for report generation.")
                    ));

        [Fact]
        public void Generate_Report_Should_Fail_If_Report_Type_Not_Supported() =>
            CreateReportGenerator()
                .GenerateReport(ReportType.Unsupported, CreateReportData())
                .Should()
                .BeLeft(error => error
                    .Should()
                    .Be(new UnsupportedReportType("Report type Unsupported not supported.")
                    ));

        private static ReportGenerator CreateReportGenerator() =>
            new(new Dictionary<ReportType, ICanGenerateReport>
            {
                {ReportType.Csv, new CsvReportGenerator()},
                {ReportType.Pdf, new PdfReportGenerator()}
            });

        private static Seq<ReportData> CreateReportData() =>
            new List<ReportData>
            {
                new(1, 100, "Sample Data 1"),
                new(2, 200, "Sample Data 2")
            }.ToSeq();
    }
}