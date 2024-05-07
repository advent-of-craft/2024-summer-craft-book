import java.util.Arrays;

public class D_Filter_Even_Numbers_Function {
    public int[] filterEvenNumbers(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).toArray();
    }
}
