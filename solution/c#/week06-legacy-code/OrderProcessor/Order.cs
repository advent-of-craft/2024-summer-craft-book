namespace OrderProcessor
{
    public class Order(int status, int items, double total)
    {
        public const int Unprocessed = 0;
        public const int Processed = 1;

        public int Status
        {
            get => status;
            set => status = value;
        }

        public int Items
        {
            get => items;
            set => items = value;
        }

        public double Total
        {
            get => total;
            set => total = value;
        }
    }
}