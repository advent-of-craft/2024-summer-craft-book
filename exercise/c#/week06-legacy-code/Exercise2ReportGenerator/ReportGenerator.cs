namespace Exercise2ReportGenerator
{
    class ReportGenerator
    {
        public void GenerateReport(string reportType, List<ReportData> data)
        {
            if (reportType == "CSV")
            {
                Console.WriteLine("Starting CSV Report Generation...");
                Console.WriteLine("CSV Header: ID, Value, Description");
                foreach (var d in data)
                {
                    Console.WriteLine($"{d.getId()},{d.getValue()},{d.getDescription()}");
                }
                Console.WriteLine("CSV Report Generated Successfully.");
            }
            else if (reportType == "PDF")
            {
                Console.WriteLine("Starting PDF Report Generation...");
                Console.WriteLine("PDF Report Title: Comprehensive Data Report");
                Console.WriteLine("------------------------------------------------");
                foreach (var d in data)
                {
                    Console.WriteLine($"Data ID: {d.getId()} | Data Value: {d.getValue()} | Description: {d.getDescription()}");
                }
                Console.WriteLine("------------------------------------------------");
                Console.WriteLine("PDF Report Generated Successfully.");
            }
            else
            {
                Console.WriteLine($"Report type {reportType} not supported.");
            }
        }
    }
}