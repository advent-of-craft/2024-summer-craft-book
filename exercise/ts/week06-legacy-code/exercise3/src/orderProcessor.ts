import {Order} from "./order";

export class OrderProcessor {
    processOrders(orders: Order[]): void {
        for (const item of orders) {
            if (item.getStatus() === Order.UNPROCESSED) {
                if (item.getItems() > 5) {
                    // apply bulk discount
                    item.setTotal(item.getTotal() * 0.9);
                }
                item.setStatus(Order.PROCESSED);
            }
        }
    }
}