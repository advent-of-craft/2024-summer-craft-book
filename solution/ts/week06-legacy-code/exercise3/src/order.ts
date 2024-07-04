export class Order {
    public static readonly UNPROCESSED = 0;
    public static readonly PROCESSED = 1;

    private status: number;
    private items: number;
    private total: number;

    constructor(status: number, items: number, total: number) {
        this.status = status;
        this.items = items;
        this.total = total;
    }

    getStatus(): number {
        return this.status;
    }

    setStatus(status: number): void {
        this.status = status;
    }

    getItems(): number {
        return this.items;
    }

    getTotal(): number {
        return this.total;
    }

    setTotal(total: number): void {
        this.total = total;
    }
}
