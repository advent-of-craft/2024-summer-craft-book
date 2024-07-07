using System.Text.Json;

namespace Exercise2GameAllProperties;

public class F_Json_Serialization_Function
{
    public string SerializeToJson(object data)
    {
        return JsonSerializer.Serialize(data);
    }
}