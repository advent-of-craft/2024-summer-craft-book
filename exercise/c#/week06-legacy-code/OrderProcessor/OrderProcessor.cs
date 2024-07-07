namespace OrderProcessor
{
    public class OrderProcessor
    {
        public void ProcessOrders(List<Order> orders)
        {
            foreach (var item in orders)
            {
                if (item.Status == Order.Unprocessed)
                {
                    if (item.Items > 5)
                    {
                        // apply bulk discount
                        item.Total *= 0.9;
                    }

                    item.Status = Order.Processed;
                }
            }
        }
    }
}