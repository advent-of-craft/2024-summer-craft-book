namespace ReportGenerator
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
                    Console.WriteLine($"{d.Id},{d.Value},{d.Description}");
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
                    Console.WriteLine($"Data ID: {d.Id} | Data Value: {d.Value} | Description: {d.Description}");
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