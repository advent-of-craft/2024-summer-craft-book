namespace Exercise2ReportGenerator;

public static class Program {
    public static void Main(string[] args) {
        var generator = new ReportGenerator();
        List<ReportData> data = [
            new ReportData(1, 100.0, "Sample Data 1"),
            new ReportData(2, 200.0, "Sample Data 2")
        ];
        generator.GenerateReport("CSV", data);
        generator.GenerateReport("PDF", data);
    }
}