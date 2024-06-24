package order

class OrderProcessor {
    fun processOrders(orders: List<Order>) {
        for (item in orders) {
            if (item.status == Order.UNPROCESSED) {
                if (item.items > 5) {
                    // apply bulk discount
                    item.total *= 0.9
                }
                item.status = Order.PROCESSED
            }
        }
    }
}