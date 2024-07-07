using FluentAssertions;
using LanguageExt;
using Xunit;

namespace ReportGenerator.Tests
{
    public class ReportGeneratorTests
    {
        [Fact]
        public void Generate_Report_In_Csv() =>
            CreateReportGenerator()
                .GenerateReport(ReportType.Csv, CreateReportData())
                .Match(
                    Right: report =>
                        report.Should()
                            .Be(
                                "Starting CSV Report Generation...\nCSV Header: ID, Value, Description\n1,100,Sample Data 1\n2,200,Sample Data 2\nCSV Report Generated Successfully."),
                    Left: error => Assert.Fail($"Unexpected error: {error}"));

        [Fact]
        public void Generate_Report_In_Pdf() =>
            CreateReportGenerator()
                .GenerateReport(ReportType.Pdf, CreateReportData())
                .Match(
                    Right: report => report.Should().Be(
                        "Starting PDF Report Generation...\nPDF Report Title: Comprehensive Data Report\n------------------------------------------------\nData ID: 1 | Data Value: 100 | Description: Sample Data 1\nData ID: 2 | Data Value: 200 | Description: Sample Data 2\n------------------------------------------------\nPDF Report Generated Successfully."),
                    Left: error => Assert.Fail($"Unexpected error: {error}")
                );

        [Fact]
        public void Generate_Report_Should_Fail_If_Report_Data_Is_Empty() =>
            CreateReportGenerator()
                .GenerateReport(ReportType.Pdf, []).Match(
                    Right: report => Assert.Fail("Expected an error but got a report"),
                    Left: error => error
                        .Should()
                        .Be(new NoDataToReport("No data provided for report generation."))
                );

        [Fact]
        public void Generate_Report_Should_Fail_If_Report_Type_Not_Supported() =>
            CreateReportGenerator()
                .GenerateReport(ReportType.Unsupported, CreateReportData())
                .Match(
                    Right: report => Assert.Fail("Expected an error but got a report"),
                    Left: error => error
                        .Should()
                        .Be(new UnsupportedReportType("Report type Unsupported not supported."))
                );

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