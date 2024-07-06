using System.Text.Json;

public class F_Json_Serialization_Function
{
    public string SerializeToJson(object data)
    {
        return JsonSerializer.Serialize(data);
    }
}