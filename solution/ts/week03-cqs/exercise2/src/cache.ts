export class Cache {
    private map: Map<string, number> = new Map<string, number>();

    get(key: string): number | undefined {
        return this.map.get(key); // Just returns the value or undefined if not present
    }

    insertIfAbsent(key: string, value: number): void {
        if (!this.map.has(key)) {
            this.map.set(key, value); // Only modifies the state, does not return value
        }
    }

    ensurePresentAndGet(key: string, defaultValue: number): number {
        this.insertIfAbsent(key, defaultValue);
        return this.get(key) ?? defaultValue;
    }
}