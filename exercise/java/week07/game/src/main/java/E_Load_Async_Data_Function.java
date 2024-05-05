import java.util.concurrent.CompletableFuture;

public class E_Load_Async_Data_Function {
    public CompletableFuture<String> loadDataAsync(String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulated delay
                Thread.sleep(1000);
                return "Data from " + url;
            } catch (InterruptedException e) {
                return "Failed to load";
            }
        });
    }

}
