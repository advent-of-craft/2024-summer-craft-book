public class D_Filter_Even_Numbers_Function
{
    public int[] FilterEvenNumbers(int[] array)
    {
        return array.Where(x => x % 2 == 0).ToArray();
    }
}