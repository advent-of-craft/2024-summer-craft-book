package order;

public class Order {
    public static final int UNPROCESSED = 0;
    public static final int PROCESSED = 1;
    private int status;
    private int items;
    private double total;

    public Order(int status, int items, double total) {
        this.status = status;
        this.items = items;
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
