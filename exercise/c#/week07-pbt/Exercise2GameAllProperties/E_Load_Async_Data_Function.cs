public class E_Load_Async_Data_Function
{
    public async Task<string> LoadDataAsync(string url)
    {
        try
        {
            // Simulated delay
            await Task.Delay(1000);
            return "Data from " + url;
        }
        catch (Exception)
        {
            return "Failed to load";
        }
    }
}