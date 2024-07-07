using System.Text.Json;

namespace AllProperties
{
    public class Functions
    {
        // A_Max_Function
        public int Max(int a, int b) => a > b ? a : b;

        // B_Sorting_Array_Function
        public int[] Sort(int[] array)
        {
            Array.Sort(array);
            return array;
        }

        // C_Trim_String_Function
        public string TrimString(string input) => input.Trim();

        // D_Filter_Even_Numbers_Function
        public int[] FilterEvenNumbers(int[] array) => array.Where(x => x % 2 == 0).ToArray();

        // E_Load_Async_Data_Function
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

        // F_Json_Serialization_Function
        public string SerializeToJson(object data) => JsonSerializer.Serialize(data);
    }
}