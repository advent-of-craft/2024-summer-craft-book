import com.google.gson.Gson;

public class F_Json_Serialization_Function {
    public String serializeToJson(Object data) {
        return new Gson().toJson(data);
    }
}
