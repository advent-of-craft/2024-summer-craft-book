namespace Exercise3GameOrderProcessor
{
    public class Order(int status, int items, double total)
    {
        public const int UNPROCESSED = 0;
        public const int PROCESSED = 1;

        public int Status
        {
            get => status;
            set => status = value;
        }

        public int Items => items;

        public double Total
        {
            get => total;
            set => total = value;
        }
    }
}
