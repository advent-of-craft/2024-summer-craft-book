package order;

import java.util.List;

public class OrderProcessor {
    public void processOrders(List<Order> orders) {
        for (Order item : orders) {
            if (item.getStatus() == Order.UNPROCESSED) {
                if (item.getItems() > 5) {
                    // apply bulk discount
                    item.setTotal(item.getTotal() * 0.9);
                }
                item.setStatus(Order.PROCESSED);
            }
        }
    }
}