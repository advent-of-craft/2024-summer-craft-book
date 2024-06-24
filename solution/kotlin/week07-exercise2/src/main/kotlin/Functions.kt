import com.google.gson.Gson
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletableFuture.supplyAsync

object Functions {
    // A_Max_Function
    fun max(a: Int, b: Int): Int = if (a > b) a else b

    // B_Sorting_Array_Function
    fun sort(array: IntArray): IntArray =
        array.sort()
            .let { return array }

    // C_Trim_String_Function
    fun trimString(input: String): String = input.trim()

    // D_Filter_Even_Numbers_Function
    fun filterEvenNumbers(array: IntArray): IntArray =
        array.filter { it % 2 == 0 }
            .toIntArray()

    // E_Load_Async_Data_Function
    fun loadDataAsync(url: String): CompletableFuture<String> =
        supplyAsync {
            try {
                // Simulated delay
                Thread.sleep(1000)
                "Data from $url"
            } catch (e: InterruptedException) {
                "Failed to load"
            }
        }

    // F_Json_Serialization_Function
    fun serializeToJson(data: Any): String = Gson().toJson(data)
}